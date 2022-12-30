package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartResponseMapper shoppingCartResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartResponseMapper shoppingCartResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PutMapping("/movie-sessions")
    @ResponseStatus(HttpStatus.OK)
    public void addSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }
}
