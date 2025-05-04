package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseDto;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> userResponseDto) {
        this.authenticationService = authenticationService;
        this.userResponseDto = userResponseDto;
    }

    @PostMapping("/register")
    public UserResponseDto add(UserRequestDto dto) {
        User registeredUser = authenticationService.register(dto.getEmail(),
                dto.getPassword());
        return userResponseDto.toDto(registeredUser);
    }
}
