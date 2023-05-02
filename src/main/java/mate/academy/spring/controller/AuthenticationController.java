package mate.academy.spring.controller;

import mate.academy.spring.exception.DataProcessingException;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    UserResponseMapper userResponseMapper,
                                    UserService userService) {
        this.authenticationService = authenticationService;
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto save(@RequestBody UserRequestDto userRequestDto) {
        if (userService.findByEmail(userRequestDto.getEmail()).isPresent()){
            throw new DataProcessingException("User with this email already exist: "
                    + userRequestDto.getEmail());
        }
        User user = authenticationService.register(userRequestDto.getEmail(),
                userRequestDto.getPassword());
        return userResponseMapper.toDto(user);
    }
}
