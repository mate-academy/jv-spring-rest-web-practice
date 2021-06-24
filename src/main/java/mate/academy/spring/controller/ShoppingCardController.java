package mate.academy.spring.controller;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCardResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.impl.response.ShoppingCardResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cards")
public class ShoppingCardController {
    private final ShoppingCartService shoppingCartService;
    private final ShoppingCardResponseMapper responseMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCardController(ShoppingCartService shoppingCartService,
                                  ShoppingCardResponseMapper responseMapper,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PostMapping("/movie-sessions")
    public ShoppingCardResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        User user = userService.getById(userId);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return responseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCardResponseDto getShoppingCardByUserId(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.getById(userId)));
    }
}
