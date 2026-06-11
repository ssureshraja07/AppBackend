package Truckmate.com.App.mapper;

import Truckmate.com.App.dto.request.RegisterRequestDTO;
import Truckmate.com.App.entity.User;

public class UserMapper {

    private UserMapper() {}

    public static User toEntity(
            RegisterRequestDTO dto
    ) {

        User user = new User();

        user.setUserMobile(
                dto.getUserMobile()
        );

        return user;
    }
}