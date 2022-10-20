package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.register.UserRegisterDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private UserResponseMapper userResponseMapper;
    private AuthenticationService authenticationService;

    public AuthenticationController(UserResponseMapper userResponseMapper,
            AuthenticationService authenticationService) {
        this.userResponseMapper = userResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegisterDto userRegisterDto) {
        return userResponseMapper.toDto(authenticationService.register(userRegisterDto.getEmail(),
                userRegisterDto.getPassword()));
    }
}
