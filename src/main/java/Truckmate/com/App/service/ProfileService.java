package Truckmate.com.App.service;

import Truckmate.com.App.dto.request.ProfileSetupRequestDTO;
import Truckmate.com.App.dto.request.UpdateProfileRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.ProfileResponseDTO;

public interface ProfileService {

    ApiResponseDTO setupProfile(
            ProfileSetupRequestDTO request
    );

    ApiResponseDTO updateProfile(
            UpdateProfileRequestDTO request
    );

    ProfileResponseDTO getProfile(
            String mobile
    );
}