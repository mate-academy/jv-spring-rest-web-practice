package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> authenMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> authenMapper) {
        this.authenticationService = authenticationService;
        this.authenMapper = authenMapper;
    }

    @PostMapping("/register")//http://localhost:8080/register
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return authenMapper.toDto(authenticationService.register(requestDto.getEmail(),
                requestDto.getPassword()));
    }
}
