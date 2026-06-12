package Truckmate.com.App.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

import Truckmate.com.App.dto.response.UploadResponseDTO;

public interface UploadService {

    UploadResponseDTO uploadProfileImage(
            MultipartFile file,
            Long userId
    ) throws IOException;
}