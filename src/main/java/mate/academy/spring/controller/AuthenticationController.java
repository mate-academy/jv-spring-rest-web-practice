package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(DtoResponseMapper<UserResponseDto, User> userResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userResponseMapper = userResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User user = authenticationService.register(
                userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userResponseMapper.toDto(user);
    }
}
