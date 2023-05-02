package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartDto;
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
    private ShoppingCartService shoppingCartService;
    private MovieSessionService movieSessionService;
    private UserService userService;
    private ShoppingCartMapper shoppingCartMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartMapper shoppingCartMapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartMapper = shoppingCartMapper;
    }

    @GetMapping("/by-user")
    public ShoppingCartDto getByUser(@RequestParam Long userId) {
        return shoppingCartMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping
    public ShoppingCartDto update(@RequestParam Long userId,
                                  @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        return shoppingCartMapper.toDto(shoppingCartService.getByUser(user));
    }
}
