package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto userRequestDto) {
        return userResponseMapper.toDto(
                authenticationService.register(userRequestDto.getEmail(),
                        userRequestDto.getPassword()));
    }

    @PostMapping("/login")
    public UserResponseDto login(@RequestBody UserRequestDto userRequestDto)
            throws AuthenticationException {
        return userResponseMapper.toDto(
                authenticationService.login(userRequestDto.getEmail(),
                        userRequestDto.getPassword()));
    }
}
