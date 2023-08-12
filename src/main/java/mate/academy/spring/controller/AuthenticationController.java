package mate.academy.spring.controller;

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
    private final AuthenticationService authenticationService;
    private final UserService userService;
    private DtoResponseMapper<UserResponseDto, User> userResponseDto;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserService userService,
                                    DtoResponseMapper<UserResponseDto, User> userResponseDto) {
        this.authenticationService = authenticationService;
        this.userService = userService;
        this.userResponseDto = userResponseDto;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        if (userService.findByEmail(userRequestDto.getEmail()).isEmpty()) {
            return userResponseDto
                    .toDto(authenticationService
                            .register(userRequestDto
                                    .getEmail(),userRequestDto.getPassword()));
        }
        return userResponseDto.toDto(userService.findByEmail(userRequestDto.getEmail()).get());
    }
}
