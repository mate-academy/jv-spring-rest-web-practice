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
    private UserService userService;
    private DtoResponseMapper<UserResponseDto, User> dtoResponse;

    public UserController(UserService userService,
                          DtoResponseMapper<UserResponseDto, User> dtoResponse) {
        this.userService = userService;
        this.dtoResponse = dtoResponse;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUser(@RequestParam String email) {
        return dtoResponse.toDto(userService.findByEmail(email).get());
    }
}
