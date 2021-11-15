package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
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
    private final ShoppingCartResponseMapper responseMapper;
    private MovieSessionService movieSessionService;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper responseMapper,
                                  MovieSessionService movieSessionService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
        return responseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto findByUser(@RequestParam Long id) {
        return responseMapper
                .toDto(shoppingCartService.getByUser(userService.get(id)));
    }
}
