package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper responseMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper responseMapper) {
        this.authenticationService = authenticationService;
        this.responseMapper = responseMapper;
    }

    //Register - POST: /register
    @PostMapping
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        User user = authenticationService.register(requestDto.getEmail(),
                requestDto.getPassword());
        return responseMapper.toDto(user);
    }
}
