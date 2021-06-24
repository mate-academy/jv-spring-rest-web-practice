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
    private final ShoppingCartService shoppingCardService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCardService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.shoppingCardService = shoppingCardService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCardService.addSession(movieSessionService
                .get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getAllByUserShoppingCart(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCardService.getByUser(userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}
