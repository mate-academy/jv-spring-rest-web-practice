package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseDtoMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseDtoMapper userResponseDtoMapper) {
        this.authenticationService = authenticationService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User registered = authenticationService
                .register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userResponseDtoMapper.toDto(registered);
    }
}
