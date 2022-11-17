package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    private MovieSessionService movieSessionService;
    private DtoResponseMapper<ShoppingCartResponseDto,
            ShoppingCart> shoppingCartResponseDtoMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartResponseDtoMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
    }

    @PutMapping("/shopping-carts/movie-sessions")
    public void addMovieSessionToShoppingCart(@RequestParam Long movieSessionId,
                                              @RequestParam Long userId) {
        shoppingCartService.addSession(
                movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/shopping-carts/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestParam Long userId) {
        return shoppingCartResponseDtoMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }
}
