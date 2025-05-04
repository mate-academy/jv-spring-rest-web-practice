package mate.academy.spring.controller;

import java.util.NoSuchElementException;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;

    @Autowired
    public UserController(UserResponseMapper userResponseMapper, UserService userService) {
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userResponseMapper.toDto(userService.findByEmail(email).orElseThrow(() ->
                new NoSuchElementException("Can't get user by email: " + email)));
    }
}
