package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserResponseMapper mapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper userResponseMapper) {
        this.service = authenticationService;
        this.mapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto requestDto) {
        return mapper.toDto(service.register(requestDto.getEmail(), requestDto.getPassword()));
    }
}
