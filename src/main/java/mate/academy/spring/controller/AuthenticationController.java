package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User> dtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registerUser(@RequestBody @Valid UserRequestDto requestDto) {
        return userDtoResponseMapper.toDto(
                authenticationService.register(requestDto.getEmail(), requestDto.getPassword()));
    }
}
