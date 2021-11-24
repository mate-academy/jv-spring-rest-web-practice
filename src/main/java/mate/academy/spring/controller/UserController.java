package mate.academy.spring.controller;

import java.util.NoSuchElementException;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users/by-email")
public class UserController {
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> userResponseDtoMapper;

    @Autowired
    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> dtoResponseMapper) {
        this.userService = userService;
        this.userResponseDtoMapper = dtoResponseMapper;
    }

    @GetMapping("/{email}")
    public UserResponseDto getUserById(@PathVariable String email) {
        try {
            return userResponseDtoMapper.toDto(userService.findByEmail(email).get());
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Cant find user by email " + email);
        }
    }
}
