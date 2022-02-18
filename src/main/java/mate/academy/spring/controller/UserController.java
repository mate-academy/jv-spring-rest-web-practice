package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResponseMapper userResponseMapper;

    public UserController(UserService userService,
                          UserResponseMapper userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userResponseMapper.toDto(userService.findByEmail(email).get());
    }

    @GetMapping("/")
    public List<UserResponseDto> getAllUsers() {
        return userService.findAll().stream()
                .map(userResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @DeleteMapping("/{id")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @GetMapping("/{id}")
    public UserResponseDto get(@PathVariable Long id) {
        return userResponseMapper.toDto(userService.get(id));
    }
}
