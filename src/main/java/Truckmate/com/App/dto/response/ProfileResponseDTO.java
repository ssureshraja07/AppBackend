package Truckmate.com.App.dto.response;

import lombok.Data;

@Data
public class ProfileResponseDTO {

    private String name;

    private Integer age;

    private String city;

    private String role;

    private String bio;

    private String profilePicture;
}