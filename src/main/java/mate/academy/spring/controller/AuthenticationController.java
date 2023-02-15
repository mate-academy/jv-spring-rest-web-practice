package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserRequestMapper dtoRequestMapper;
    private final UserResponseMapper dtoResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserRequestMapper dtoRequestMapper,
                                    UserResponseMapper dtoResponseMapper) {
        this.authenticationService = authenticationService;
        this.dtoRequestMapper = dtoRequestMapper;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDto register(@RequestBody @Valid UserRequestDto requestDto) {
        User user = dtoRequestMapper.fromDto(requestDto);
        User registeredUser = authenticationService.register(user.getEmail(), user.getPassword());
        return dtoResponseMapper.toDto(registeredUser);
    }
}
