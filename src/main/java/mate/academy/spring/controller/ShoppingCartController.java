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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseMapper;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> dtoResponseMapper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.getById(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return dtoResponseMapper.toDto(shoppingCart);
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }
}
