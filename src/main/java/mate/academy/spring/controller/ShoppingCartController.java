package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseDtoMapper;
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
    private ShoppingCartService shoppingCartService;
    private MovieSessionService movieSessionService;
    private ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper;
    private UserService userService;

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
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long movieSessionId,
                                                   @RequestParam Long userId) {
        User user = userService.get(userId);
        shoppingCartService
                .addSession(movieSessionService.get(movieSessionId), user);
        return shoppingCartResponseDtoMapper
                .toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return shoppingCartResponseDtoMapper
                .toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
