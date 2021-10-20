package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.request.UserRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.UserResponseMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationController(UserService userService, UserRequestMapper userRequestMapper,
                                    UserResponseMapper userResponseMapper,
                                    ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody @Valid UserRequestDto user) {
        User addedUser = userService.add(userRequestMapper.fromDto(user));
        shoppingCartService.registerNewShoppingCart(userRequestMapper.fromDto(user));
        return userResponseMapper.toDto(addedUser);
    }
}
