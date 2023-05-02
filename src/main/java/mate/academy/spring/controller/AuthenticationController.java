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
    private final AuthenticationService authService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;
    private final UserService userService;

    public AuthenticationController(AuthenticationService authService,
                                    DtoResponseMapper<UserResponseDto, User> userResponseMapper,
                                    UserService userService) {
        this.authService = authService;
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto requestDto) {
        String email = requestDto.getEmail();
        if (userService.findByEmail(email).isPresent()) {
            throw new RuntimeException("Invalid registration data!");
        }
        User user = authService.register(email, requestDto.getPassword());
        return userResponseMapper.toDto(user);
    }
}
