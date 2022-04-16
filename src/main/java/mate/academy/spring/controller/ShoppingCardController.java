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
public class ShoppingCardController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCardController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto add(@RequestParam Long userId,
                                        @RequestParam Long movieSessionId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .addSession(movieSessionService.get(movieSessionId),
                userService.get(userId)));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
