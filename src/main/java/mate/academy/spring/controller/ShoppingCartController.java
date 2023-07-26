package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService cartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper;

    public ShoppingCartController(
            ShoppingCartService cartService,
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper) {
        this.cartService = cartService;
        this.mapper = mapper;
    }

    @PutMapping("/movie-sessions")
    public void add(@RequestParam Long userId, Long movieSessionId) {
        cartService.addSession(new MovieSession(movieSessionId), new User(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return mapper.toDto(cartService.getByUser(new User(userId)));
    }
}
