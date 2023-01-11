package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserResponseMapper userResponseMapper;
    private UserService userService;

    public UserController(UserResponseMapper userResponseMapper, UserService userService) {
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email/{email}")
    public UserResponseDto getByEmail(@PathVariable String email) {
        Optional<User> userOptional = userService.findByEmail(email);
        return userResponseMapper.toDto(userOptional.get());
    }
}
