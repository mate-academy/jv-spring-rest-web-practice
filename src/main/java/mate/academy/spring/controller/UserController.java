package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    public UserController(UserService userService, UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        Optional<User> optionalUser = userService.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new NoSuchElementException("User by email " + email + " doesn't exist");
        }
        return userResponseMapper.toDto(optionalUser.get());
    }
}
