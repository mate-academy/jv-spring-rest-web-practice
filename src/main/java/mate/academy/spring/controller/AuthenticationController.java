package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registerUser(UserRegistrationDto registrationDto) {
        authenticationService.register(registrationDto.getEmail(),
                registrationDto.getPassword());
    }
}
