package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService, UserService userService,
                                    UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }
    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto)
        throws AuthenticationException {
        if (userService.findByEmail(userRequestDto.getEmail()).isEmpty()) {
            return userResponseMapper
                .toDto(authenticationService
                    .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
        }
        throw new AuthenticationException("User already exists: " + userRequestDto.getEmail());
    }
}
