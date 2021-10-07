package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.request.ShoppingCartRequestMapper;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final ShoppingCartRequestMapper shoppingCartRequestMapper;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  ShoppingCartRequestMapper shoppingCartRequestMapper,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.shoppingCartRequestMapper = shoppingCartRequestMapper;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @GetMapping("by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("movie-sessions")
    public void addMovieSession(@RequestParam Long movieSessionId,
                                                   @RequestParam Long userId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), userService.get(userId));
    }
}
