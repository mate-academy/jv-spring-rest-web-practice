package mate.academy.spring.controller;

import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService service) {
        authenticationService = service;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
