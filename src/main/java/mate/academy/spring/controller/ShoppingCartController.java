package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final UserService userService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartResponseMapper;
    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
        this.shoppingCartResponseMapper = shoppingCartResponseMapper;
    }

    @PutMapping("/movie-sessions?{userId}&{movieSessionId}")
    public ShoppingCartResponseDto addMovieSessionByUserId(@PathVariable Long userId,
                                       @PathVariable Long movieSessionId) {
        User user = userService.get(userId);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user?{userId}")
    public ShoppingCartResponseDto getByUserId(@PathVariable Long userId) {
        return shoppingCartResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
