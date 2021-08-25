package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResposeMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserResposeMapper userResposeMapper;

    public UserController(UserService userService,
            UserResposeMapper userResposeMapper) {
        this.userService = userService;
        this.userResposeMapper = userResposeMapper;
    }

    @GetMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userResposeMapper.toDto(userService.findByEmail(email).get());
    }
}
