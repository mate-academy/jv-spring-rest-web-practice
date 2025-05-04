package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.service.impl.ShoppingCartServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final ShoppingCartServiceImpl shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartResponseMapper responseMapper,
                                  ShoppingCartServiceImpl shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartResponseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getById(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-session")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
