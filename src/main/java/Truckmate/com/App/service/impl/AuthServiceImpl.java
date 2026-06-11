package Truckmate.com.App.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

import Truckmate.com.App.dto.request.LoginRequestDTO;
import Truckmate.com.App.dto.request.RegisterRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.LoginResponseDTO;

import Truckmate.com.App.entity.User;
import Truckmate.com.App.entity.UserProfile;

import Truckmate.com.App.mapper.UserMapper;

import Truckmate.com.App.repository.UserRepository;
import Truckmate.com.App.repository.UserProfileRepository;

import Truckmate.com.App.service.AuthService;

@Service
@RequiredArgsConstructor

public class AuthServiceImpl
        implements AuthService {

    private final UserRepository userRepository;

    private final UserProfileRepository
            userProfileRepository;

    @Override
    public ApiResponseDTO register(
            RegisterRequestDTO request
    ) {

        Optional<User> existingUser =
                userRepository.findByUserMobile(
                        request.getUserMobile()
                );

        if (existingUser.isPresent()) {

            return new ApiResponseDTO(
                    false,
                    "User already exists"
            );
        }

        User user =
                UserMapper.toEntity(request);

        userRepository.save(user);

        return new ApiResponseDTO(
                true,
                "User created successfully"
        );
    }

    @Override
    public LoginResponseDTO login(
            LoginRequestDTO request
    ) {

        Optional<User> userOptional =
                userRepository.findByUserMobile(
                        request.getUserMobile()
                );

        if (userOptional.isEmpty()) {

            return new LoginResponseDTO(
                    false,
                    "User not found",
                    false
            );
        }

        User user = userOptional.get();

        Optional<UserProfile> profile =
                userProfileRepository
                        .findByUser(user);

        return new LoginResponseDTO(
                true,
                "Login successful",
                profile.isPresent()
        );
    }
}