package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final UserResponseMapper userResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserResponseMapper userResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userResponseMapper = userResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userResponseMapper.toDto(authenticationService
                .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
    }
}
