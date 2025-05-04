package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper userResponseMapper) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void register(@RequestBody @Valid UserRequestDto dto) {
        authenticationService.register(dto.getEmail(), dto.getPassword());
    }
}
