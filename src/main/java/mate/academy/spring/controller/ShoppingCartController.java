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
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService service,
            ShoppingCartResponseMapper mapper, UserService userService,
            MovieSessionService movieSessionService) {
        this.shoppingCartService = service;
        this.shoppingCartResponseMapper = mapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
            @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.finById(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(
                shoppingCartService.getByUser(
                        userService.finById(userId)));
    }
}
