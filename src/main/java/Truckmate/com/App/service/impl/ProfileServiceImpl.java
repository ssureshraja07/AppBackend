package Truckmate.com.App.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

import Truckmate.com.App.dto.request.ProfileSetupRequestDTO;
import Truckmate.com.App.dto.request.UpdateProfileRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.ProfileResponseDTO;

import Truckmate.com.App.entity.User;
import Truckmate.com.App.entity.UserProfile;

import Truckmate.com.App.mapper.ProfileMapper;

import Truckmate.com.App.repository.UserRepository;
import Truckmate.com.App.repository.UserProfileRepository;

import Truckmate.com.App.service.ProfileService;

@Service
@RequiredArgsConstructor

public class ProfileServiceImpl
        implements ProfileService {

    private final UserRepository userRepository;

    private final UserProfileRepository
            profileRepository;

    @Override
    public ApiResponseDTO setupProfile(
            ProfileSetupRequestDTO request
    ) {

        Optional<User> userOptional =
                userRepository.findByUserMobile(
                        request.getUserMobile()
                );

        if (userOptional.isEmpty()) {

            return new ApiResponseDTO(
                    false,
                    "User not found"
            );
        }

        User user = userOptional.get();

        Optional<UserProfile> existingProfile =
                profileRepository.findByUser(
                        user
                );

        if (existingProfile.isPresent()) {

            return new ApiResponseDTO(
                    false,
                    "Profile already exists"
            );
        }

        UserProfile profile =
                ProfileMapper.toEntity(
                        request,
                        user
                );

        profileRepository.save(profile);

        return new ApiResponseDTO(
                true,
                "Profile setup completed"
        );
    }

    @Override
    public ApiResponseDTO updateProfile(
            UpdateProfileRequestDTO request
    ) {

        Optional<User> userOptional =
                userRepository.findByUserMobile(
                        request.getUserMobile()
                );

        if (userOptional.isEmpty()) {

            return new ApiResponseDTO(
                    false,
                    "User not found"
            );
        }

        User user = userOptional.get();

        Optional<UserProfile> profileOptional =
                profileRepository.findByUser(
                        user
                );

        if (profileOptional.isEmpty()) {

            return new ApiResponseDTO(
                    false,
                    "Profile not found"
            );
        }

        UserProfile profile =
                profileOptional.get();

        ProfileMapper.updateEntity(
                profile,
                request
        );

        profileRepository.save(profile);

        return new ApiResponseDTO(
                true,
                "Profile updated successfully"
        );
    }

    @Override
    public ProfileResponseDTO getProfile(
            String mobile
    ) {

        User user =
                userRepository
                        .findByUserMobile(mobile)
                        .orElseThrow();

        UserProfile profile =
                profileRepository
                        .findByUser(user)
                        .orElseThrow();

        return ProfileMapper
                .toResponseDTO(profile);
    }
}