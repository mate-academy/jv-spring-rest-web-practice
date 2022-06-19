package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseDtoMapper;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/by-user")
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        return shoppingCartResponseDtoMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public void update(@RequestParam Long userId, Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }
}
