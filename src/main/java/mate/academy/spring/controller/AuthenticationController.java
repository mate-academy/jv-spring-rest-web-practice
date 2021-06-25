package mate.academy.spring.controller;

import javax.validation.Valid;
import mate.academy.spring.exception.RegistrationException;
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
    private final AuthenticationService authenticationService;
    private final UserResponseMapper responseMapper;

    public AuthenticationController(AuthenticationService service,
                                    UserResponseMapper responseMapper) {
        this.authenticationService = service;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto registrationDto)
            throws RegistrationException {
        User user = authenticationService.register(registrationDto.getEmail(),
                registrationDto.getPassword(), registrationDto.getRepeatPassword());
        return responseMapper.parseToDto(user);
    }
}
