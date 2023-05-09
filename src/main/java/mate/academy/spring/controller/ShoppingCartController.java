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
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;
    private final UserService userService;
    private final ShoppingCartService cartService;
    private final MovieSessionService sessionService;

    public ShoppingCartController(DtoResponseMapper<ShoppingCartResponseDto,
                                                    ShoppingCart> responseMapper,
                                  UserService userService,
                                  ShoppingCartService cartService,
                                  MovieSessionService sessionService) {
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.cartService = cartService;
        this.sessionService = sessionService;
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        cartService.addSession(sessionService.get(movieSessionId), userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return responseMapper.toDto(cartService.getByUser(userService.get(userId)));
    }
}
