package Truckmate.com.App.service.impl;
import Truckmate.com.App.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Optional;
import Truckmate.com.App.dto.request.LoginRequestDTO;
import Truckmate.com.App.dto.request.RegisterRequestDTO;
import Truckmate.com.App.dto.response.ApiResponseDTO;
import Truckmate.com.App.dto.response.LoginResponseDTO;
import Truckmate.com.App.entity.User;
import Truckmate.com.App.mapper.UserMapper;
import Truckmate.com.App.repository.UserRepository;
import Truckmate.com.App.service.AuthService;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl
        implements AuthService {

    private final UserRepository userRepository;

    private final JwtService jwtService;

    @Override
    public ApiResponseDTO register(
            RegisterRequestDTO request
    ) {

        Optional<User> existingUser =
                userRepository.findByMobileNumber(
                        request.getMobileNumber()
                );

        if (existingUser.isPresent()) {

            return new ApiResponseDTO(
                    false,
                    "User already exists"
            );
        }

        User user =
                UserMapper.toEntity(request);

        userRepository.save(user);

        return new ApiResponseDTO(
                true,
                "User created successfully"
        );
    }

    @Override
    public LoginResponseDTO login(
            LoginRequestDTO request
    ) {

        Optional<User> userOptional =
                userRepository.findByMobileNumber(
                        request.getUserMobile()
                );

        if (userOptional.isEmpty()) {

            return new LoginResponseDTO(
                    false,
                    "User not found",
                    false,
                    null,
                    null

            );
        }

        User user =
                userOptional.get();
        String token =
                jwtService.generateToken(
                        user.getId()
                );

        boolean profileCompleted =
                user.getCity() != null
                        &&
                        !user.getCity().isBlank()
                        &&
                        user.getProfilePicture() != null
                        &&
                        !user.getProfilePicture().isBlank();

        return new LoginResponseDTO(
                true,
                "Login successful",
                profileCompleted,
                token,
                user.getId()
        );
    }
}