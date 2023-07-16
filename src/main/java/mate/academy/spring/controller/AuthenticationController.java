package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;
    private final UserRequestMapper userRequestMapper;

    public AuthenticationController(UserService userService,
                                    UserResponseMapper userResponseMapper,
                                    UserRequestMapper userRequestMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
        this.userRequestMapper = userRequestMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto userRequestDto) {
        User user = userService.add(userRequestMapper.fromDto(userRequestDto));
        return userResponseMapper.toDto(user);
    }
}
