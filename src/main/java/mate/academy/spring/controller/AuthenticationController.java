package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void register(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }

}
