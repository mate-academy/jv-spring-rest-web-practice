package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapping shoppingCartMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapping shoppingCartMapper,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public void addToCart(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(
                    movieSessionService.get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return shoppingCartMapper.toDto(shoppingCartService.getByUser(user));
    }
}
