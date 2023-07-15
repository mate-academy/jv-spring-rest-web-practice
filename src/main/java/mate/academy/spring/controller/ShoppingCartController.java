package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PutMapping("/movie-sessions/{/userId}{/movieSessionId}")
    public ShoppingCartResponseDto addMovieSession(@PathVariable Long userId,
                                                   @PathVariable Long movieSessionId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSession, user);
        return shoppingCartResponseMapper
                .toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user/{/userId}")
    public ShoppingCartResponseDto getByUser(@PathVariable Long userId) {
        User user = userService.get(userId);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
