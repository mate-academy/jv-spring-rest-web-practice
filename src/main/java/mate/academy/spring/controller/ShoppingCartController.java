package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final UserService userService;

    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  UserService userService) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto updateShoppingCart(@RequestParam Long userId,
                                                      @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getCartByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
