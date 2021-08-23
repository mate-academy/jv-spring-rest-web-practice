package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationServiceImpl;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationServiceImpl authenticationService;
    private final UserResponseMapper userResponseMapper;
    
    public AuthenticationController(AuthenticationServiceImpl authenticationService,
                                    UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }
    
    @PostMapping
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto userRegistrationDto) {
        return userResponseMapper.toDto(authenticationService
                .register(userRegistrationDto.getEmail(),
                        userRegistrationDto.getPassword()));
    }
}
