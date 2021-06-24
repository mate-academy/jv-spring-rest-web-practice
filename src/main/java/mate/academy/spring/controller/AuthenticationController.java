package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final UserResponseMapper responseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserResponseMapper responseMapper,
                                    AuthenticationService authenticationService) {
        this.responseMapper = responseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto request) {
        if (request.getPassword().equals(request.getRepeatPassword())) {
            responseMapper
                    .toDto(authenticationService
                            .register(request.getEmail(), request.getPassword()));
        }
        throw new RuntimeException("Passwords do not match");
    }
}
