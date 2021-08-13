package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartResponseMapper cartResponseMapper;

    public ShoppingCartController(ShoppingCartService cartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartResponseMapper cartResponseMapper) {
        this.cartService = cartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.cartResponseMapper = cartResponseMapper;
    }

    @PostMapping("/movie-session")
    public void addMovieSession(@RequestParam(value = "userId") Long userId,
                                @RequestParam(value = "movieSessionId") Long movieSessionId) {
        cartService.addSession(movieSessionService.get(movieSessionId),
                userService.getById(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getCartByUser(@RequestParam Long userId) {
        ShoppingCart shoppingCart = cartService.getByUser(userService.getById(userId));
        return cartResponseMapper.toDto(shoppingCart);
    }

}
