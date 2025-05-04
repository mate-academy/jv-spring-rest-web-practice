package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
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
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseShoppingCart;

    public ShoppingCartController(
            ShoppingCartService shoppingCartService, MovieSessionService movieSessionService,
            UserService userService,
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseShoppingCart) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.dtoResponseShoppingCart = dtoResponseShoppingCart;
    }

    @PutMapping("/movie-session")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return dtoResponseShoppingCart.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }
}
