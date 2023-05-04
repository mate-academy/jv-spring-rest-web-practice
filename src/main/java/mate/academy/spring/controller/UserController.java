package mate.academy.spring.controller;

import java.util.NoSuchElementException;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    @Autowired
    public UserController(UserService userService,
                          UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/users")
    public UserResponseDto get(@PathVariable String email) {
        return userResponseMapper
                .toDto(userService.findByEmail(email)
                        .orElseThrow(() ->
                                new NoSuchElementException("The user is absent")
                        ));
    }
}
