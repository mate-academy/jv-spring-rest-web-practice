package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper;
    private final DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper;

    public UserController(UserService userService,
                          DtoRequestMapper<UserRequestDto, User> userDtoRequestMapper,
                          DtoResponseMapper<UserResponseDto, User> userDtoResponseMapper) {
        this.userService = userService;
        this.userDtoRequestMapper = userDtoRequestMapper;
        this.userDtoResponseMapper = userDtoResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto get(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(
                () -> new NoSuchElementException("Can't find user by email: " + email));
        return userDtoResponseMapper.toDto(user);
    }

}
