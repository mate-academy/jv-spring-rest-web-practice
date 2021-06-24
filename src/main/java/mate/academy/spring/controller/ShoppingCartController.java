package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
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
    private UserService userService;
    private ShoppingCartService shoppingCartService;
    private MovieSessionService movieSessionService;
    private ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        User user = userService.getById(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }

    @PostMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
