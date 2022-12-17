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
    private final UserService userService;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.userService = userService;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto findUserByEmail(@RequestParam String email) {
        return userDtoResponseMapper.toDto(userService.findByEmail(email).orElseThrow(() ->
                new NoSuchElementException("Can't find user by email " + email)));
    }
}
