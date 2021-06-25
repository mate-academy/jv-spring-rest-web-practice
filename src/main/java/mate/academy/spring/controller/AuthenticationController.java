package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserResponseMapper userDtoMapper;

    public AuthenticationController(AuthenticationService service,
                                    UserResponseMapper userDtoMapper) {
        this.service = service;
        this.userDtoMapper = userDtoMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto requestDto) {
        User user = service.register(requestDto.getEmail(), requestDto.getPassword());
        return userDtoMapper.toDto(user);
    }
}
