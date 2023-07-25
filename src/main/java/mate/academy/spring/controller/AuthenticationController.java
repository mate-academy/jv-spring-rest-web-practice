package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(
            DtoResponseMapper<UserResponseDto, User> dtoResponseMapper,
            AuthenticationService authenticationService) {
        this.dtoResponseMapper = dtoResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto dto) {
        User registeredUser = authenticationService.register(dto.getEmail(), dto.getPassword());
        return dtoResponseMapper.toDto(registeredUser);
    }
}
