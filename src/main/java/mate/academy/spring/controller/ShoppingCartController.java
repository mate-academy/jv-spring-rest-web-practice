package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private UserService userService;
    private MovieSessionService movieSessionService;
    private DtoResponseMapper<ShoppingCartResponseDto,
            ShoppingCart> responseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> responseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.responseMapper = responseMapper;
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSession, user);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return responseMapper.toDto(shoppingCart);
    }
}
