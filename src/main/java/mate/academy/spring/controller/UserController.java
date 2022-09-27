package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseDtoMapper;
import mate.academy.spring.model.dto.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserController(UserService userService, UserResponseDtoMapper userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam String email) {
        return userResponseDtoMapper.toDto(userService
                .findByEmail(email).get());
    }
}
