package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseDtoMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;
    private UserResponseDtoMapper userResponseDtoMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseDtoMapper userResponseDtoMapper) {
        this.authenticationService = authenticationService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(
            @RequestBody @Valid AuthenticationRequestDto authenticationRequestDto) {
        return userResponseDtoMapper
                .toDto(authenticationService.register(authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword()));
    }
}
