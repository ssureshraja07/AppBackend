package Truckmate.com.App.dto.response;

import lombok.Data;

@Data
public class PostResponseDTO {

    private Long id;

    private String fromLocation;

    private String toLocation;

    private String travelDate;

    private String travelTime;

    private String description;

    private String postImage;
}