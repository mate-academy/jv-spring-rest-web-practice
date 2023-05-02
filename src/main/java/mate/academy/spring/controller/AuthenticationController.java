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
    private final DtoResponseMapper<UserResponseDto,User> userDtoResponseMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            DtoResponseMapper<UserResponseDto, User> userResponseMapper
    ) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto add(@RequestBody UserRequestDto dto) {
        return userDtoResponseMapper
                .toDto(authenticationService.register(dto.getEmail(), dto.getPassword()));
    }
}
