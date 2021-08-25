package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.UserResposeMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class UserController {
    private final UserService userService;
    private final UserResposeMapper userRequestMapper;
    private final UserResposeMapper userResposeMapper;

    public UserController(UserService userService,
            UserResposeMapper userRequestMapper,
            UserResposeMapper userResposeMapper) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResposeMapper = userResposeMapper;
    }

    @PostMapping("/by-email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userResposeMapper.toDto(userService.findByEmail(email).get());
    }
}
