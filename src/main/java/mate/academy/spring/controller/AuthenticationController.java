package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;
    private final DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper;

    public AuthenticationController(UserService userService,
                                    AuthenticationService authenticationService,
                                    DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper) {
        this.userService = userService;
        this.authenticationService = authenticationService;
        this.userDtoRequestMapper = userDtoRequestMapper;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRequestDto requestDto) {
        authenticationService.register(requestDto.getEmail(), requestDto.getPassword());
    }
}
