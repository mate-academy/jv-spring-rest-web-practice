package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.UserRegistrationDtoMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private UserService userService;
    private UserRegistrationDtoMapper registrationDtoMapper;
    private UserResponseMapper responseMapper;

    public AuthenticationController(UserService userService,
                                    UserRegistrationDtoMapper registrationDtoMapper,
                                    UserResponseMapper responseMapper) {
        this.userService = userService;
        this.registrationDtoMapper = registrationDtoMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registerUser(UserRegistrationDto registrationDto) {
        User user = registrationDtoMapper.toModel(registrationDto);
        return responseMapper.toDto(userService.add(user));
    }
}
