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
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> cartMapper;
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          cartMapper,
                                  ShoppingCartService cartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.cartMapper = cartMapper;
        this.cartService = cartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return cartMapper.toDto(cartService.getByUser(userService.getById(userId)));
    }

    @PutMapping ("/movie-sessions")
    public void addMovieSessionToCart(@RequestParam Long userId,
                                      @RequestParam Long movieSessionId) {
        cartService.addSession(movieSessionService.get(movieSessionId),
                userService.getById(userId));
    }
}
