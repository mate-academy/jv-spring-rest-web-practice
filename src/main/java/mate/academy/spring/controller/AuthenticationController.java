package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserRequestMapper userRequestMapper;
    private final AuthenticationService authenticationService;

    public AuthenticationController(UserRequestMapper userRequestMapper,
                                    AuthenticationService authenticationService) {
        this.userRequestMapper = userRequestMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRequestDto userRequestDto) {
        authenticationService.register(userRequestDto.getEmail(), userRequestDto.getPassword());
    }
}
