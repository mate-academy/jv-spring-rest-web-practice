package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<UserResponseDto, User>
            userResponseMapper;

    public UserController(UserService userService,
                          ShoppingCartService shoppingCartService,
                          DtoResponseMapper<UserResponseDto, User> userResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping
    public UserResponseDto get(@RequestParam String email) {
        return userResponseMapper.toDto(userService.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("There is no user with email: "
                        + email + ", or it is not valid")));
    }
}
