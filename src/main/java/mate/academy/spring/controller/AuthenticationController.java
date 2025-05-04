package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserService userService,
                                    UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(UserRequestDto userRequestDto) {
        if (userService.findByEmail(userRequestDto.getEmail()).get() != null) {
            throw new RuntimeException(
                    "User already exist with email " + userRequestDto.getEmail());
        }
        return userResponseMapper.toDto(authenticationService
                .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
    }
}
