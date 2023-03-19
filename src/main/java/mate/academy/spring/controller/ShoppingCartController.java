package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final ShoppingCartRequestMapper shoppingCartRequestMapper;

    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  ShoppingCartRequestMapper shoppingCartRequestMapper,
                                  UserService userService, MovieService movieService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")//http://localhost:8080/shopping-carts/movie-sessions?userId=&movieSessionId=
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user") ///shopping-carts/by-user?userId
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper
                .toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
