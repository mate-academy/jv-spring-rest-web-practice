package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private DtoResponseMapper<UserResponseDto, User> userResponseDtoMapper;
    private UserService userService;

    @Autowired
    public UserController(DtoResponseMapper<UserResponseDto, User> userResponseDtoMapper,
                          UserService userService) {
        this.userResponseDtoMapper = userResponseDtoMapper;
        this.userService = userService;
    }

    @GetMapping("/users/by-email")
    public UserResponseDto findByEmail(@RequestParam String email) {
        return userResponseDtoMapper.toDto(userService.findByEmail(email).get());
    }
}
