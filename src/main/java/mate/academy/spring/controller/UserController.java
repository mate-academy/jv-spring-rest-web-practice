package mate.academy.spring.controller;

import jakarta.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;

    public UserController(UserResponseMapper userResponseMapper, UserService userService) {
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public List<UserResponseDto> getByEmail(@RequestParam @Valid String email) {
        return userService.findByEmail(email)
                .stream()
                .map(userResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
