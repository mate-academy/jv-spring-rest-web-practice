package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.AuthenticationRequestDto;
import mate.academy.spring.model.dto.response.AuthenticationResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authService;

    public AuthenticationController(AuthenticationService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public AuthenticationResponseDto add(@RequestBody AuthenticationRequestDto requestDto) {
        User registeredUser = authService
                .register(requestDto.getEmail(), requestDto.getPassword());
        return new AuthenticationResponseDto(registeredUser.getId(), registeredUser.getEmail());
    }
}
