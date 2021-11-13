package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
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
    public String register(@RequestBody @Valid AuthenticationRequestDto authenticationRequestDto) {
        authenticationService.register(authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword());
        return "user " + authenticationRequestDto.getEmail() + " registered";
    }
}
