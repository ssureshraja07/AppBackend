package Truckmate.com.App.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponseDTO {

    private boolean success;

    private String message;

    private boolean profileCompleted;

    private String token;

    private Long userId;
}