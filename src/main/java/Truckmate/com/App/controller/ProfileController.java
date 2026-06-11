package Truckmate.com.App.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import Truckmate.com.App.dto.request.ProfileSetupRequestDTO;
import Truckmate.com.App.dto.request.UpdateProfileRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.ProfileResponseDTO;

import Truckmate.com.App.service.ProfileService;

@RestController
@RequestMapping("/api/profile")

@RequiredArgsConstructor
public class ProfileController {

    private final ProfileService profileService;

    @PostMapping("/setup")
    public ApiResponseDTO setupProfile(
            @RequestBody ProfileSetupRequestDTO request
    ) {

        return profileService.setupProfile(request);
    }

    @PutMapping("/update")
    public ApiResponseDTO updateProfile(
            @RequestBody UpdateProfileRequestDTO request
    ) {

        return profileService.updateProfile(request);
    }

    @GetMapping
    public ProfileResponseDTO getProfile(
            @RequestParam String mobile
    ) {

        return profileService.getProfile(mobile);
    }
}