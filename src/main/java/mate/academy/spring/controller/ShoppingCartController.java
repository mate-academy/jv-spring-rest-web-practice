package mate.academy.spring.controller;

import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCartResponseMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final ShoppingCartResponseMapper responseMapper;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartResponseMapper responseMapper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }
}
