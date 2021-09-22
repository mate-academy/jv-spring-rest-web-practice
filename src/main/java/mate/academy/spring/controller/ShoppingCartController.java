package mate.academy.spring.controller;

import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                                shoppingCartDtoResponseMapper;

    public ShoppingCartController(UserService userService,
            MovieSessionService movieSessionService,
            ShoppingCartService shoppingCartService,
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartDtoResponseMapper) {
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestBody @Validated
                                                           ShoppingCartRequestDto dto) {
        User user = userService.get(dto.getUserId());
        MovieSession movieSession = movieSessionService.get(dto.getMovieSessionId());
        shoppingCartService.addSession(movieSession, user);
        return shoppingCartDtoResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        User user = userService.get(userId);
        return shoppingCartDtoResponseMapper.toDto(shoppingCartService.getByUser(user));
    }
}
