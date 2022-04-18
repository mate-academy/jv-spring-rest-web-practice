package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper cartResponseMapper;

    public ShoppingCartController(UserService userService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper cartResponseMapper) {
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.cartResponseMapper = cartResponseMapper;
    }

    @PutMapping("/movie-sessions")
    public void add(Long userId, Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto get(Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return cartResponseMapper.toDto(shoppingCart);
    }
}
