package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
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
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseMapper;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> dtoResponseMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSessionService
                .get(movieSessionId), user);
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getShoppingCartByUser(@RequestParam Long userId) {
        return dtoResponseMapper
                .toDto(shoppingCartService
                        .getByUser(userService.get(userId)));
    }
}
