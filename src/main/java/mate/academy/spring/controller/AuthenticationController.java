package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authService,
                                    UserResponseMapper userResponseMapper) {
        this.authService = authService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping()
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return userResponseMapper.toDto(authService.register(requestDto.getEmail(),
                                                            requestDto.getPassword()));
    }
}
