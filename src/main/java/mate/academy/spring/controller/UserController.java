package mate.academy.spring.controller;

import mate.academy.spring.exception.DataProcessingException;
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
    private UserService userService;
    private DtoResponseMapper<UserResponseDto, User> userResponseMapper;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).orElseThrow(() ->
                new DataProcessingException("User with email " + email + " does not exist"));
        return userResponseMapper.toDto(user);
    }
}
