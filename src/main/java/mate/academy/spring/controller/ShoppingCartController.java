package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.mapper = mapper;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    private void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.findById(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto findByUser(@RequestParam Long userId) {
        ShoppingCart cart = shoppingCartService.getByUser(userService.findById(userId));
        return mapper.toDto(cart);
    }
}
