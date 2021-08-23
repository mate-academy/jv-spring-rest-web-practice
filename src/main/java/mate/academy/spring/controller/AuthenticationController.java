package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public void register(@RequestBody AuthenticationRequestDto authenticationRequestDto) {
        service.register(authenticationRequestDto.getEmail(),
                authenticationRequestDto.getPassword());
    }
}
