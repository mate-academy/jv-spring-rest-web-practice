package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(
            ShoppingCartService shoppingCartService,
            UserService userService,
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper,
            MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public void update(@RequestParam Long id, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(id));
    }

    @GetMapping("by-user/{userId}")
    public ShoppingCartResponseDto getByUser(@PathVariable Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return responseMapper.toDto(shoppingCart);
    }
}
