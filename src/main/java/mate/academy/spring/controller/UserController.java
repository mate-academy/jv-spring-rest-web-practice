package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/by-email")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userDtoResponseMapper;

    public UserController(UserService userService, UserResponseMapper userDtoResponseMapper) {
        this.userService = userService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userDtoResponseMapper.toDto(userService.findByEmail(email).orElseThrow(() ->
                new RuntimeException("User with this email is not exist" + email)));
    }
}
