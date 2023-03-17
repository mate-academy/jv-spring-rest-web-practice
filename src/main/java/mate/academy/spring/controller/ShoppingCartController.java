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
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @Autowired
    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto add(@RequestParam Long userId,
                                       @RequestParam Long movieSessionId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);

        shoppingCartService.addSession(movieSession, user);

        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        User user = userService.get(userId);

        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);

        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}
