package mate.academy.spring.controller;

import java.util.Optional;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;
    private final UserService userService;

    public UserController(DtoResponseMapper<UserResponseDto, User> userResponseMapper,
                          UserService userService) {
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
    }

    @GetMapping("/by-email")
    public UserResponseDto userByEmail(@RequestParam String email) {
        Optional<User> userByEmail = userService.findByEmail(email);
        if (userByEmail.isPresent()) {
            return userResponseMapper.toDto(userByEmail.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find user by email "
                    + email);
        }
    }
}
