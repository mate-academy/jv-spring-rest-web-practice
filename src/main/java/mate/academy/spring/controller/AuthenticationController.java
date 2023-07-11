package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
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
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    public AuthenticationController(AuthenticationService authenticationService,
            UserResponseMapper userResponseMapper, UserRequestMapper userRequestMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto dto) {
        userRequestMapper.fromDto(dto);
        User user = authenticationService.register(dto.getEmail(), dto.getPassword());
        return userResponseMapper.toDto(user);
    }
}
