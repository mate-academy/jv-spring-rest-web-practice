package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
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
    private final DtoRequestMapper<UserRequestDto, User>
            userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User>
            userDtoResponseMapper;

    public AuthenticationController(
            UserService userService,
            DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper,
            DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper
    ) {
        this.userService = userService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        User registeredUser = userService.add(userDtoRequestMapper.fromDto(userRequestDto));
        return userDtoResponseMapper.toDto(registeredUser);
    }
}
