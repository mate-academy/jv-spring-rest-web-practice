package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(DtoResponseMapper<UserResponseDto, User> dtoResponseMapper,
                                    AuthenticationService authenticationService) {
        this.dtoResponseMapper = dtoResponseMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return dtoResponseMapper.toDto(authenticationService.register(
                requestDto.getEmail(), requestDto.getPassword()));
    }
}
