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
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseMapper;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam String email) {
        Optional<User> userOptional = userService.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find user by email: "
                    + email);
        } else {
            return userResponseMapper.toDto(userOptional.get());
        }
    }
}
