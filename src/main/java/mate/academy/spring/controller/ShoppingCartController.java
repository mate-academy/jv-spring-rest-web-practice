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
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartResponseMapper,
            ShoppingCartService shoppingCartService,
            UserService userService,
            MovieSessionService movieSessionService
    ) {
        this.responseMapper = shoppingCartResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("movie-sessions")
    public ShoppingCartResponseDto addMovieSession(
            @RequestParam Long userId,
            Long movieSessionId) {
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return responseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
