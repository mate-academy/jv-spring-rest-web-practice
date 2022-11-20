package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.AuthenticationResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final AuthenticationResponseMapper authenticationResponseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    AuthenticationResponseMapper authenticationResponseMapper) {
        this.authenticationService = authenticationService;
        this.authenticationResponseMapper = authenticationResponseMapper;
    }

    @PostMapping
    public UserResponseDto register(UserRequestDto userRequestDto) {
        return authenticationResponseMapper.toDto(
                authenticationService.register(
                        userRequestDto.getEmail(),
                        userRequestDto.getPassword()));
    }
}
