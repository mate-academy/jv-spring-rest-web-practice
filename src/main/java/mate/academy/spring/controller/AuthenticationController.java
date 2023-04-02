package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserResponseMapper userResponseMapper,
                                    UserRequestMapper userRequestMapper,
                                    AuthenticationService authenticationService) {
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = userRequestMapper.fromDto(userRequestDto);
        return userResponseMapper.toDto(
                authenticationService.register(user.getEmail(), user.getPassword()));
    }
}
