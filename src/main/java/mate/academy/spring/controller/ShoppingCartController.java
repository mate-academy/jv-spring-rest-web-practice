package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartService shoppCartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper;
    private final MovieSessionService movieSessionService;

    @Autowired
    public ShoppingCartController(UserService userService, ShoppingCartService shoppCartService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> mapper,
                                  MovieSessionService movieSessionService) {
        this.userService = userService;
        this.shoppCartService = shoppCartService;
        this.mapper = mapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return mapper.toDto(shoppCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    @ResponseStatus(HttpStatus.OK)
    public void addMovieSession(@RequestParam Long userId, @RequestParam Long movieSessionId) {
        shoppCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }
}
