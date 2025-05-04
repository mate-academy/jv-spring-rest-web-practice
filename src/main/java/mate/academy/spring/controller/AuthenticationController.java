package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        try {
            authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
        } catch (AuthenticationException e) {
            throw new RuntimeException("Can't register user with email: "
                    + userRequestDto.getEmail(), e);
        }
    }
}
