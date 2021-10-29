package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam("userId") Long id) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(id));
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }

    @PutMapping("/movie-sessions")
    public void addSession(@RequestParam("userId") Long userId,
                            @RequestParam("movieSessionId") Long sessionId) {
        shoppingCartService.addSession(movieSessionService.get(sessionId), userService.get(userId));
    }
}
