package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserResponseMapper mapper;

    public AuthenticationController(AuthenticationService authService, UserResponseMapper mapper) {
        this.authService = authService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto dto) {
        return mapper.toDto(authService.register(dto.getEmail(), dto.getPassword()));
    }
}
