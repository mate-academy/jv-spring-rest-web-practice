package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.impl.request.UserRequestMapper;
import mate.academy.spring.mapper.impl.response.UserResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final UserRequestMapper requestMapper;
    private final UserResponseMapper responseMapper;

    public AuthenticationController(UserService userService,
                                    ShoppingCartService shoppingCartService,
                                    UserRequestMapper requestMapper,
                                    UserResponseMapper responseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.requestMapper = requestMapper;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/register")
    public UserResponseDto registration(@RequestBody UserRequestDto dto) throws
            AuthenticationException {
        if (userService.findByEmail(dto.getEmail()).isEmpty()) {
            User user = userService.add(requestMapper.fromDto(dto));
            shoppingCartService.registerNewShoppingCart(user);
            return responseMapper.toDto(user);
        }
        throw new AuthenticationException("User with email: "
                + dto.getEmail()
                + " already exists.");
    }
}
