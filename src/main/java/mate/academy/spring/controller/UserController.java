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
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;
    private final UserService userService;

    public UserController(DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper,
                          UserService userService) {
        this.userDtoResponseMapper = userDtoResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    UserResponseDto getByEmail(@RequestParam String email) {
        return userDtoResponseMapper.toDto(userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Invalid email: " + email)));
    }
}
