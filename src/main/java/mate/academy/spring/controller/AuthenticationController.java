package mate.academy.spring.controller;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class AuthenticationController {
    private final UserRequestMapper userRequestMapper;
    private final UserResponseMapper userResponseMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public AuthenticationController(UserRequestMapper userRequestMapper,
                                    UserResponseMapper userResponseMapper, UserService userService,
                                    ShoppingCartService shoppingCartService) {
        this.userRequestMapper = userRequestMapper;
        this.userResponseMapper = userResponseMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping
    public UserResponseDto register(@RequestBody @Valid UserRegistrationDto dto) {
        User user = userRequestMapper.fromDto(dto);
        User userFromDB = userService.add(user);
        shoppingCartService.registerNewShoppingCart(userFromDB);
        return userResponseMapper.toDto(userFromDB);
    }
}
