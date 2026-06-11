package Truckmate.com.App.dto.request;

import lombok.Data;

@Data
public class CreatePostRequestDTO {

    private String userMobile;

    private String fromLocation;

    private String toLocation;

    private String travelDate;

    private String travelTime;

    private String description;

    private String postImage;
}