package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final DtoRequestMapper<UserRequestDto, User>
            userDtoRequestMapper;

    public AuthenticationController(UserService userService,
            DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper) {
        this.userService = userService;
        this.userDtoRequestMapper = userDtoRequestMapper;
    }

    @PostMapping("/register")
    public void register(UserRequestDto userRequestDto) {
        userService.add(userDtoRequestMapper.fromDto(userRequestDto));
    }
}
