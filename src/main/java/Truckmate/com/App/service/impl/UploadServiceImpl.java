package Truckmate.com.App.service.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import Truckmate.com.App.dto.response.UploadResponseDTO;
import Truckmate.com.App.entity.User;
import Truckmate.com.App.repository.UserRepository;
import Truckmate.com.App.service.UploadService;

@Service
@RequiredArgsConstructor
public class UploadServiceImpl
        implements UploadService {

    private final UserRepository userRepository;

    @Override
    public UploadResponseDTO uploadProfileImage(
            MultipartFile file,
            Long userId
    ) throws IOException {

        User user = userRepository
                .findById(userId)
                .orElseThrow(
                        () -> new RuntimeException(
                                "User not found"
                        )
                );

        String uploadDir =
                System.getProperty("user.dir")
                        + "/uploads/profiles/";

        File directory =
                new File(uploadDir);

        if (!directory.exists()) {
            directory.mkdirs();
        }

        String fileName =
                UUID.randomUUID()
                        + "_"
                        + file.getOriginalFilename();

        String filePath =
                uploadDir + fileName;

        File destinationFile =
                new File(filePath);

        file.transferTo(destinationFile);

        // Save image path in DB
        user.setProfilePicture(filePath);
        userRepository.save(user);

        return new UploadResponseDTO(
                true,
                filePath
        );
    }
}