package Truckmate.com.App.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

import Truckmate.com.App.dto.response.UploadResponseDTO;
import Truckmate.com.App.service.UploadService;

@RestController
@RequestMapping("/api/upload")

@RequiredArgsConstructor
public class UploadController {

    private final UploadService
            uploadService;


    @PostMapping(
            value = "/profile-image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE
    )
    public UploadResponseDTO uploadProfileImage(

            @RequestParam("file")
            MultipartFile file,

            @RequestParam("userId")
            Long userId

    ) throws IOException {

        return uploadService
                .uploadProfileImage(
                        file,
                        userId
                );
    }
}