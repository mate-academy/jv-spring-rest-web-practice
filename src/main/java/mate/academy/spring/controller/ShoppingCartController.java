package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  MovieSessionService movieSessionService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto byUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }
}
