package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
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
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCartResponseMapper responseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper responseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long movieSessionId,
                                       @RequestParam Long userId) {
        shoppingCartService.addSession(new MovieSession(movieSessionId), new User(userId));
        ShoppingCart shoppingCart = shoppingCartService.getByUser(new User(userId));
        return responseMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(new User(userId));
        return responseMapper.toDto(shoppingCart);
    }
}
