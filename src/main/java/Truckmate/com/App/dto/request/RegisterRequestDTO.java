package Truckmate.com.App.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterRequestDTO {

    private String mobileNumber;
    private String name;
    private LocalDate dob;
    private String role;
}