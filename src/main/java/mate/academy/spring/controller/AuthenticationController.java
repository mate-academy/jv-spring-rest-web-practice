package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserRequestMapper userRequestMapper,
                                    UserResponseMapper userResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto dto) {
        User registeredUser = authenticationService.register(dto.getEmail(), dto.getPassword());
        return userResponseMapper.toDto(registeredUser);
    }
}
