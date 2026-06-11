package Truckmate.com.App.dto.request;

import lombok.Data;

@Data
public class UpdateProfileRequestDTO {

    private String userMobile;

    private String name;

    private Integer age;

    private String city;

    private String role;

    private String bio;

    private String profilePicture;
}