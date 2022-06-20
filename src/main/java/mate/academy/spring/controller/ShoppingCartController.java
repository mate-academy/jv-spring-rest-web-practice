package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
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
@RequestMapping("/shoping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
            shoppingCartResponseMapper;

    public ShoppingCartController(UserService userService,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @GetMapping
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
        return shoppingCartResponseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
