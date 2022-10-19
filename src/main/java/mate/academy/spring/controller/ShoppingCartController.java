package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ShoppingCartResponseMapper responseMapper;
    private ShoppingCartResponseDto responseDto;


    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ShoppingCartResponseMapper responseMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  ShoppingCartResponseDto responseDto) {
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.responseDto = responseDto;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        MovieSession session = movieSessionService.get(movieSessionId);
        shoppingCartService.addSession(session, user);
        return responseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
