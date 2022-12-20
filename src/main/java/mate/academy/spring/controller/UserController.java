package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private final UserService userService;
    private final UserResponseMapper responseMapper;

    public UserController(UserService userService, UserResponseMapper responseMapper) {
        this.userService = userService;
        this.responseMapper = responseMapper;
    }

    @GetMapping("/users/by-email")
    public UserResponseDto getByEmail(@RequestParam(name = "email") String email) {
        Optional<User> optionalUser = userService.findByEmail(email);
        return responseMapper.toDto(optionalUser.orElseThrow());
    }
}
