package Truckmate.com.App.dto.response;

import lombok.*;

@Data
@AllArgsConstructor

public class LoginResponseDTO {

    private boolean success;

    private String message;

    private boolean profileCompleted;
}