package Truckmate.com.App.service;

import Truckmate.com.App.dto.request.LoginRequestDTO;
import Truckmate.com.App.dto.request.RegisterRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.LoginResponseDTO;

public interface AuthService {

    ApiResponseDTO register(
            RegisterRequestDTO request
    );

    LoginResponseDTO login(
            LoginRequestDTO request
    );
}