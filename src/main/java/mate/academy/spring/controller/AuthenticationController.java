package mate.academy.spring.controller;

import lombok.RequiredArgsConstructor;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authService;

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto requestDto) {
        authService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
