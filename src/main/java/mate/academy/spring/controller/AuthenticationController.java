package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final DtoResponseMapper<UserResponseDto,User> userDtoResponseMapper;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(DtoResponseMapper<UserResponseDto,User> userDtoResponseMapper,
                                    AuthenticationService authenticationService) {
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userDtoResponseMapper
                .toDto(authenticationService
                .register(userRequestDto.getEmail(),
                userRequestDto.getPassword()));
    }
}
