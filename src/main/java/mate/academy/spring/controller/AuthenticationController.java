package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;
    private final DtoResponseMapper<UserResponseDto, User> mapper;

    public AuthenticationController(
            AuthenticationService authService, DtoResponseMapper<UserResponseDto, User> mapper) {
        this.authService = authService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {
        return mapper.toDto(authService.register(dto.getEmail(), dto.getPassword()));
    }
}
