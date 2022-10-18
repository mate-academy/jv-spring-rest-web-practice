package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
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
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper userResponseMapper,
                                    UserService userService) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
        User user = userService.findByEmail(requestDto.getEmail())
                .orElseThrow(() -> new RuntimeException("Can't find user by email: "
                        + requestDto.getEmail()));
        return userResponseMapper.toDto(user);
    }
}
