package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
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
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final DtoResponseMapper<ShoppingCartResponseDto,
            ShoppingCart> responseMapper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService cartService, UserService userService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          responseMapper,
                                  MovieSessionService movieSessionService) {
        this.cartService = cartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addSession(@RequestParam Long userId,
                                              @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        cartService.addSession(movieSession, user);
        return responseMapper.toDto(cartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart cart = cartService.getByUser(user);
        return responseMapper.toDto(cart);
    }
}
