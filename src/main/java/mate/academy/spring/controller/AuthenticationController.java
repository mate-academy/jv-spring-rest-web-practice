package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserResponseMapper userResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserResponseMapper mapper, AuthenticationService service) {
        this.userResponseMapper = mapper;
        this.authenticationService = service;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestParam UserRequestDto userRequestDto) {
        return userResponseMapper.toDto(authenticationService
                .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
    }
}
