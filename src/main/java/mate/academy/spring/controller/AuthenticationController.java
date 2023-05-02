package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
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
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authenticationService,
                                    DtoResponseMapper<UserResponseDto, User>
                                            userDtoResponseMapper,
                                    UserService userService) {
        this.authenticationService = authenticationService;
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        if (userService.findByEmail(userRequestDto.getEmail()).isPresent()) {
            throw new RuntimeException("User with email: " + userRequestDto.getEmail() + " exist");
        }
        User user = authenticationService
                .register(userRequestDto.getEmail(), userRequestDto.getPassword());
        return userDtoResponseMapper.toDto(user);
    }
}
