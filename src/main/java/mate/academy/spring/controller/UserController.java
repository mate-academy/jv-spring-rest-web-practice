package mate.academy.spring.controller;

import java.util.NoSuchElementException;
import mate.academy.spring.mapper.impl.response.UserResponseDtoMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserController(UserService userService, UserResponseDtoMapper userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/{userId}")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userResponseDtoMapper.toDto(userService
                .findByEmail(email).orElseThrow(NoSuchElementException::new));
    }
}
