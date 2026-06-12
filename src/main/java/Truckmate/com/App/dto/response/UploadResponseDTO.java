package Truckmate.com.App.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UploadResponseDTO {

    private Boolean success;

    private String imageUrl;
}