package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserResponseMapper userDtoResponseMapper;

    public AuthenticationController(AuthenticationService service,
                                    UserResponseMapper userDtoResponseMapper) {
        this.service = service;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRequestDto requestDto) {
        User register = service.register(requestDto.getEmail(), requestDto.getPassword());
        userDtoResponseMapper.toDto(register);
    }
}
