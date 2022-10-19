package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRegistrationDto userRegistrationDto) {
        return userResponseMapper.toDto(
                authenticationService.register(
                        userRegistrationDto.getEmail(), userRegistrationDto.getPassword()));
    }

}
