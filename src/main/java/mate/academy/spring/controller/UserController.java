package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.AuthenticationResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final AuthenticationResponseMapper authenticationResponseMapper;

    @Autowired
    public UserController(UserService userService,
                          AuthenticationResponseMapper authenticationResponseMapper) {
        this.userService = userService;
        this.authenticationResponseMapper = authenticationResponseMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        User user = userService.findByEmail(email).get();
        return authenticationResponseMapper.toDto(user);
    }
}
