package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.model.dto.request.UserRequestDto;
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
    public void register(@RequestBody UserRequestDto requestDto) {
        service.register(requestDto.getEmail(), requestDto.getPassword());
    }

    @PostMapping("/login")
    public void login(@RequestBody UserRequestDto requestDto) throws AuthenticationException {
        service.login(requestDto.getEmail(), requestDto.getPassword());
    }
}
