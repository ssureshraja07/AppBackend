package Truckmate.com.App.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class UserResponseDTO {

    private Long id;

    private String mobileNumber;

    private String name;

    private LocalDate dob;

    private String role;

    private String city;

    private String profilePicture;
}