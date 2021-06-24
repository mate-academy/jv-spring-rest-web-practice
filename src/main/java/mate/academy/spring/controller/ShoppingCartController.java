package mate.academy.spring.controller;

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
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PostMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.getById(userId)));
    }
}
