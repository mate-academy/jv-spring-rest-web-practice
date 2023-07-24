package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authService;
    private final DtoResponseMapper<UserResponseDto, User> mapper;

    public AuthenticationController(
            UserService userService, AuthenticationService authService,
            DtoResponseMapper<UserResponseDto, User> mapper) {
        this.userService = userService;
        this.authService = authService;
        this.mapper = mapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto dto)
            throws AuthenticationException {
        if (userService.findByEmail(dto.getEmail()).isEmpty()) {
            return mapper.toDto(authService.register(dto.getEmail(), dto.getPassword()));
        }
        throw new AuthenticationException("This email is already present");
    }
}
