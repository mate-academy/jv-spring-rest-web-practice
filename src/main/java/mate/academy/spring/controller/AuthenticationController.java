package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> authenticationResponseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User>
                                            authenticationResponseMapper) {
        this.authenticationService = authenticationService;
        this.authenticationResponseMapper = authenticationResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(UserRequestDto userRequestDto) {
        return authenticationResponseMapper.toDto(
                authenticationService.register(
                        userRequestDto.getEmail(),
                        userRequestDto.getPassword()));
    }
}
