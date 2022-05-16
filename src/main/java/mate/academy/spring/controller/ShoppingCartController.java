package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartReponseDto;
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
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartReponseDto, ShoppingCart>
                                    shoppingCartDtoResponseMapper;

    public ShoppingCartController(UserService userService,
            ShoppingCartService shoppingCartService,
            MovieSessionService movieSessionService,
            DtoResponseMapper<ShoppingCartReponseDto, ShoppingCart> cartDtoResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartDtoResponseMapper = cartDtoResponseMapper;
    }

    @GetMapping("/users")
    public ShoppingCartReponseDto getShoppingCartByUser(
            @RequestParam(value = "userId") Long userId) {
        return shoppingCartDtoResponseMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartReponseDto addMovieSessionToShoppingCart(
            @RequestParam(value = "userId") Long userId,
            @RequestParam(value = "movieSessionId") Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        return shoppingCartDtoResponseMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }
}
