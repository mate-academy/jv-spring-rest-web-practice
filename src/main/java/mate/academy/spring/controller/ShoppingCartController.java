package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PostMapping("/movie-sessions")
    public ShoppingCartResponseDto add(@RequestParam Long userId,
                                       @RequestParam Long movieSessionId) {
        User user = userService.findById(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseDtoMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.findById(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseDtoMapper.toDto(shoppingCart);
    }
}
