package mate.academy.spring.controller;

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
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final ShoppingCartResponseMapper mapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  ShoppingCartResponseMapper mapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.mapper = mapper;
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.getById(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUserId(@RequestParam Long userId) {
        return mapper.toDto(shoppingCartService.getByUser(userService.getById(userId)));
    }
}
