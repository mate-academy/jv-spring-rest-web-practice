package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
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
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper,
                                  ShoppingCartService shoppingCartService, UserService userService,
                                  MovieSessionService movieSessionService) {
        this.mapper = mapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return mapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public void update(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(
                movieSessionService.get(movieSessionId),
                userService.get(userId));
    }
}
