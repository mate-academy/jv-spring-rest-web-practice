package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> authDtoResponseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    UserService userService,
                                    DtoResponseMapper<UserResponseDto, User>
                                            authDtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.authDtoResponseMapper = authDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto)
            throws AuthenticationException {
        if (userService.findByEmail(userRequestDto.getEmail()).isEmpty()) {
            return authDtoResponseMapper
                .toDto(authenticationService
                    .register(userRequestDto.getEmail(), userRequestDto.getPassword()));
        }
        throw new AuthenticationException("User already exists: " + userRequestDto.getEmail());
    }
}
