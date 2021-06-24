package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserResponseMapper responseMapper;

    public AuthenticationController(AuthenticationService service,
                                    UserResponseMapper responseMapper) {
        this.service = service;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto registrationDto) {
        User user = service.register(registrationDto.getEmail(), registrationDto.getPassword());
        return responseMapper.parseToDto(user);
    }
}
