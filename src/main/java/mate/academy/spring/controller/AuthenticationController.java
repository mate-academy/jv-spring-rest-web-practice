package mate.academy.spring.controller;

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
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> responseMapper) {
        this.authenticationService = authenticationService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto registrationDto) {
        User user = authenticationService
                .register(registrationDto.getEmail(), registrationDto.getPassword());
        return responseMapper.toDto(user);
    }
}
