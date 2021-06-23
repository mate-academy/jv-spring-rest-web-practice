package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService sessionService;
    private final UserService userService;
    private final ShoppingCartService cartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;

    public ShoppingCartController(MovieSessionService sessionService,
                                  UserService userService, ShoppingCartService cartService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> responseMapper) {
        this.sessionService = sessionService;
        this.userService = userService;
        this.cartService = cartService;
        this.responseMapper = responseMapper;
    }

    @PostMapping("/movie-sessions")
    public String addMovieSession(@RequestParam Long userId, @RequestParam Long sessionId) {
        User user = userService.getById(userId);
        MovieSession movieSession = sessionService.get(sessionId);
        cartService.addSession(movieSession, user);
        return "Movie Session Was Added Successfully!";
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto findByUser(@RequestParam Long userId) {
        User user = userService.getById(userId);
        return responseMapper.toDto(cartService.getByUser(user));
    }

}
