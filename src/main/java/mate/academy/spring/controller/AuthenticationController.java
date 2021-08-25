package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final UserService userService;
    private final DtoRequestMapper<UserRequestDto, User>
            userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User>
            userDtoResponseMapper;

    public AuthenticationController(UserService userService,
            DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper,
            DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.userService = userService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @PostMapping
    public void register(UserRequestDto userRequestDto) {
        userService.add(userDtoRequestMapper.fromDto(userRequestDto));
    }
}
