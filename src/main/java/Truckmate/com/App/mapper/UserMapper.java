package Truckmate.com.App.mapper;

import Truckmate.com.App.dto.request.RegisterRequestDTO;
import Truckmate.com.App.dto.request.UpdateProfileRequestDTO;
import Truckmate.com.App.dto.response.UserResponseDTO;
import Truckmate.com.App.entity.User;

public class UserMapper {

    private UserMapper() {
    }

    // REGISTER DTO -> ENTITY
    public static User toEntity(
            RegisterRequestDTO dto
    ) {

        User user = new User();

        user.setMobileNumber(
                dto.getMobileNumber()
        );

        user.setName(
                dto.getName()
        );

        user.setDob(
                dto.getDob()
        );

        user.setRole(
                dto.getRole()
        );

        return user;
    }

    // ENTITY -> RESPONSE DTO
    public static UserResponseDTO toResponseDTO(
            User user
    ) {

        UserResponseDTO dto =
                new UserResponseDTO();

        dto.setId(
                user.getId()
        );

        dto.setMobileNumber(
                user.getMobileNumber()
        );

        dto.setName(
                user.getName()
        );

        dto.setDob(
                user.getDob()
        );

        dto.setRole(
                user.getRole()
        );

        dto.setCity(
                user.getCity()
        );

        dto.setProfilePicture(
                user.getProfilePicture()
        );

        return dto;
    }

    // UPDATE PROFILE
    public static void updateEntity(
            User user,
            UpdateProfileRequestDTO dto
    ) {

        user.setCity(
                dto.getCity()
        );

        user.setProfilePicture(
                dto.getProfilePicture()
        );
    }
}