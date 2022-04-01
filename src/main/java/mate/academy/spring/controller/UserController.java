package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.mapper.impl.response.UserResponseDtoMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final UserResponseDtoMapper userResponseDtoMapper;

    public UserController(UserService userService,
                          UserResponseDtoMapper userResponseDtoMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = userResponseDtoMapper;
    }

    @GetMapping("/users/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        Optional<User> byEmail = userService.findByEmail(email);
        User user = byEmail.orElseThrow(() -> new RuntimeException("No user with email: " + email));
        return userResponseDtoMapper.toDto(user);
    }
}
