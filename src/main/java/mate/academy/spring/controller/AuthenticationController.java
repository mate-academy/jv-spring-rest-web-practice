package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserService userService) {
        this.authenticationService = authenticationService;
        this.userService = userService;
    }

    @PostMapping("/register")
    public void register(@RequestBody UserRequestDto userRequestDto)
            throws AuthenticationException {
        if (userService.findByEmail(userRequestDto.getEmail()).isEmpty()) {
            authenticationService.register(userRequestDto.getEmail(),
                    userRequestDto.getPassword());
        }
        throw new AuthenticationException("This email is already registered: "
                + userRequestDto.getEmail());
    }
}
