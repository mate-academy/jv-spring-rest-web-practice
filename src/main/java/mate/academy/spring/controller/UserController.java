package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final DtoResponseMapper<UserResponseDto, User> mapper;
    private final UserService userService;

    public UserController(DtoResponseMapper<UserResponseDto, User> mapper,
                          UserService userService) {
        this.mapper = mapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    UserResponseDto get(@RequestParam String email) {
        return mapper.toDto(userService.findByEmail(email).orElseThrow(() ->
                new RuntimeException("Can't get user by email: " + email)));
    }
}
