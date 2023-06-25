package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
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
    private final DtoResponseMapper<UserResponseDto, User> userResponseDtoMapper;
    private final UserService userService;

    public UserController(UserResponseMapper<UserResponseDto, User> userResponseDtoMapper,
                          UserService userService) {
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.userService = userService;
    }

    @GetMapping("by-email")
    public UserResponseDto getByEmail(@RequestParam String email) {
        return userResponseDtoMapper.toDto(userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Can't find user by email : " + email)));
    }
}
