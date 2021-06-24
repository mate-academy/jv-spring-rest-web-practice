package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cards")
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> cartDtoResponseMapper;

    public ShoppingCartController(ShoppingCartService cartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          cartDtoResponseMapper) {
        this.cartService = cartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.cartDtoResponseMapper = cartDtoResponseMapper;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return cartDtoResponseMapper.toDto(cartService.getByUser(userService.get(userId)));
    }

    @PostMapping("/movie-sessions")
    public ShoppingCartResponseDto addSession(@RequestParam Long userId,
                                               @RequestParam Long movieSessionId) {
        cartService.addSession(movieSessionService.get(movieSessionId), userService.get(userId));
        return cartDtoResponseMapper.toDto(cartService.getByUser(userService.get(userId)));
    }
}
