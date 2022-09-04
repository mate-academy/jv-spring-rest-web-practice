package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final DtoResponseMapper<MovieSessionResponseDto, MovieSession>
            movieSessionResponseMapper;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
            shoppingCartResponseMapper;

    @Autowired
    public ShoppingCartController(MovieSessionService movieSessionService,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  DtoResponseMapper<MovieSessionResponseDto,
                                          MovieSession> movieSessionResponseMapper,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartResponseMapper) {
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionResponseMapper = movieSessionResponseMapper;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PutMapping("/movie-sessions")
    public MovieSessionResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
        return movieSessionResponseMapper.toDto(movieSession);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return shoppingCartResponseMapper.toDto(shoppingCart);
    }
}
