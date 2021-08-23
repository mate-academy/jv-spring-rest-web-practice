package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final DtoRequestMapper<UserRegistrationRequestDto, User> userDtoRequestMapper;

    public AuthenticationController(
            AuthenticationService authenticationService,
            DtoRequestMapper<UserRegistrationRequestDto, User> userDtoRequestMapper) {
        this.authenticationService = authenticationService;
        this.userDtoRequestMapper = userDtoRequestMapper;
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserRegistrationRequestDto userRegistrationRequestDto) {
        User user = userDtoRequestMapper.fromDto(userRegistrationRequestDto);
        authenticationService.register(user.getEmail(), user.getPassword());
    }
}
