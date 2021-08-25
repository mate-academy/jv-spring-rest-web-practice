package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartRequestMapper shoppingCartRequestMapper;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(MovieSessionService movieSessionService,
            UserService userService,
            ShoppingCartService shoppingCartService,
            ShoppingCartRequestMapper shoppingCartRequestMapper,
            ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PutMapping("/movie-session")
    public void addMovieSession(@RequestParam Long userId,
            @RequestParam Long movieSessionId) {
        shoppingCartService
                .addSession(movieSessionService.get(movieSessionId),
                        userService.findById(userId).get());
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper
                .toDto(shoppingCartService.getByUser(userService.findById(userId).get()));
    }
}
