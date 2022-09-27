package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseDtoMapper;
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
    private final ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    private ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseDtoMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
