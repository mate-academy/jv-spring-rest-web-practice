package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
