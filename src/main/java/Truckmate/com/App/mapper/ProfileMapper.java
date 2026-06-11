package Truckmate.com.App.mapper;

import Truckmate.com.App.dto.request.ProfileSetupRequestDTO;
import Truckmate.com.App.dto.request.UpdateProfileRequestDTO;
import Truckmate.com.App.dto.response.ProfileResponseDTO;

import Truckmate.com.App.entity.User;
import Truckmate.com.App.entity.UserProfile;

public class ProfileMapper {

    private ProfileMapper() {}

    // CREATE PROFILE
    public static UserProfile toEntity(
            ProfileSetupRequestDTO dto,
            User user
    ) {

        UserProfile profile =
                new UserProfile();

        profile.setUser(user);

        profile.setName(
                dto.getName()
        );

        profile.setAge(
                dto.getAge()
        );

        profile.setCity(
                dto.getCity()
        );

        profile.setRole(
                dto.getRole()
        );

        return profile;
    }

    // UPDATE PROFILE
    public static void updateEntity(
            UserProfile profile,
            UpdateProfileRequestDTO dto
    ) {

        profile.setName(
                dto.getName()
        );

        profile.setAge(
                dto.getAge()
        );

        profile.setCity(
                dto.getCity()
        );

        profile.setRole(
                dto.getRole()
        );

        profile.setBio(
                dto.getBio()
        );

        profile.setProfilePicture(
                dto.getProfilePicture()
        );
    }

    // ENTITY -> RESPONSE DTO
    public static ProfileResponseDTO
    toResponseDTO(
            UserProfile profile
    ) {

        ProfileResponseDTO dto =
                new ProfileResponseDTO();

        dto.setName(
                profile.getName()
        );

        dto.setAge(
                profile.getAge()
        );

        dto.setCity(
                profile.getCity()
        );

        dto.setRole(
                profile.getRole()
        );

        dto.setBio(
                profile.getBio()
        );

        dto.setProfilePicture(
                profile.getProfilePicture()
        );

        return dto;
    }
}