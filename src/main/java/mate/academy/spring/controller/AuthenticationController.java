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
    private final DtoRequestMapper<UserRequestDto, User>
            userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User>
            userDtoResponseMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper,
            DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper
    ) {
        this.authenticationService = authenticationService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User registeredUser = authenticationService.register(
                userRequestDto.getEmail(),
                userRequestDto.getPassword()
        );

        return userDtoResponseMapper.toDto(registeredUser);
    }
}
