package mate.academy.spring.controller;

import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserResponseMapper responseMapper;

    public AuthenticationController(AuthenticationService service,
                                    UserResponseMapper responseMapper) {
        this.service = service;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        return responseMapper.toDto(service.register(requestDto.getEmail(),
                requestDto.getPassword()));
    }
}
