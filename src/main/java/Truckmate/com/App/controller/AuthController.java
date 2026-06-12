package Truckmate.com.App.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

import Truckmate.com.App.dto.request.LoginRequestDTO;
import Truckmate.com.App.dto.request.RegisterRequestDTO;

import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.LoginResponseDTO;

import Truckmate.com.App.service.AuthService;

@RestController
@RequestMapping("/api/auth")

@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    public ApiResponseDTO register(
            @RequestBody RegisterRequestDTO request
    ) {

        return authService.register(request);
    }

    @PostMapping("/login")
    public LoginResponseDTO login(
            @RequestBody LoginRequestDTO request
    ) {

        return authService.login(request);
    }


}