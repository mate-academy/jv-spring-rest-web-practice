package mate.academy.spring.controller;

import mate.academy.spring.exception.AuthenticationException;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
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
    private final DtoRequestMapper<UserRequestDto, User> requestMapper;
    private final DtoResponseMapper<UserResponseDto, User> responseMapper;

    public AuthenticationController(UserService userService,
                                    ShoppingCartService shoppingCartService,
                                    DtoRequestMapper<UserRequestDto, User> requestMapper,
                                    DtoResponseMapper<UserResponseDto, User> responseMapper) {
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
