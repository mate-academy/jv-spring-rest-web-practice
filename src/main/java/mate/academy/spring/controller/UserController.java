package mate.academy.spring.controller;

import java.util.NoSuchElementException;
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
    private final DtoResponseMapper<UserResponseDto, User> dtoResponseMapper;
    private final UserService userService;

    public UserController(DtoResponseMapper<UserResponseDto, User> dtoResponseMapper,
                          UserService userService) {
        this.dtoResponseMapper = dtoResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUsersByEmail(@RequestParam String email) {
        if (userService.findByEmail(email).isEmpty()) {
            throw new NoSuchElementException("Can't find user by email " + email);
        }
        return dtoResponseMapper.toDto(userService.findByEmail(email).get());
    }
}
