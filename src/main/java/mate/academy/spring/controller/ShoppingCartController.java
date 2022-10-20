package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
            ShoppingCartResponseMapper shoppingCartResponseMapper,
            MovieSessionService movieSessionService, UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCart(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}
