package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService cartService;
    private UserService userService;
    private MovieSessionService sessionService;
    private DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;

    public ShoppingCartController(ShoppingCartService cartService,
                                  UserService userService,
                                  MovieSessionService sessionService,
                                  ShoppingCartResponseMapper responseMapper) {
        this.cartService = cartService;
        this.userService = userService;
        this.sessionService = sessionService;
        this.responseMapper = responseMapper;
    }

    @PutMapping("/movie-sessions")
    public void addSession(@RequestParam Long userId,
                           @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession session = sessionService.get(movieSessionId);
        cartService.addSession(session, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        ShoppingCart cart = cartService.getByUser(userService.get(userId));
        return responseMapper.toDto(cart);
    }
}
