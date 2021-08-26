package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoRequestMapper<UserRegistrationRequestDto, User> userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            UserRequestMapper userDtoRequestMapper,
            UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(
            @RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = userDtoRequestMapper.fromDto(userRegistrationRequestDto);
        authenticationService.register(user.getEmail(), user.getPassword());
        return userResponseMapper.toDto(user);
    }
}
