package mate.academy.spring.controller;

import java.util.NoSuchElementException;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
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
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> dtoResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @GetMapping("/by-user/{userId}")
    public ShoppingCartResponseDto getByUser(@PathVariable Long userId) {
        try {
            return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
        } catch (NoSuchElementException e) {
            throw new RuntimeException("Cant find shopping cart user id " + userId);
        }
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService
                .get(movieSessionId),userService
                .get(userId));
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

}
