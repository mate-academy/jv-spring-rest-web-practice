package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
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
    private final DtoRequestMapper<UserRequestDto, User> userRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            DtoRequestMapper<UserRequestDto, User> userRequestMapper,
            DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.userRequestMapper = userRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = userRequestMapper.fromDto(requestDto);
        authenticationService.register(user.getEmail(), user.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}
