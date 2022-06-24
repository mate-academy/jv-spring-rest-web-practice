package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cards")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService, UserService userService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PostMapping
    public void addMovieSession(@PathVariable Long userId,
                                @PathVariable Long movieSessionId) {
        shoppingCartService.addSession(
                movieSessionService.get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/id")
    public ShoppingCartResponseDto getByUser(@PathVariable Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}
