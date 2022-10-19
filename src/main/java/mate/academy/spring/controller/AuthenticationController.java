package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public AuthenticationController(UserService userService, UserRequestMapper userRequestMapper,
                                    UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        return userResponseMapper.toDto(userService.add(userRequestMapper.fromDto(
                userRequestDto)));
    }
}
