package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private UserRequestMapper requestMapper;
    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(UserRequestMapper requestMapper,
                                    AuthenticationService authenticationService) {
        this.requestMapper = requestMapper;
        this.authenticationService = authenticationService;
    }

    @PostMapping
    public void register(@RequestBody UserRequestDto userRequestDto) {
        User user = requestMapper.fromDto(userRequestDto);
        authenticationService.register(user.getEmail(), user.getPassword());
    }
}
