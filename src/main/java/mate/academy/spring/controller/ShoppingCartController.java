package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final DtoResponseMapper<ShoppingCartResponseDto,
            ShoppingCart> shoppingCartDtoResponseMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartDtoResponseMapper,
            UserService userService, ShoppingCartService shoppingCartService,
            MovieSessionService movieSessionService) {
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartDtoResponseMapper.toDto(
                shoppingCartService.getByUser(
                        userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addSession(
            @RequestParam Long userId, @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        shoppingCartService.addSession(
                movieSessionService.get(movieSessionId), user);
        return shoppingCartDtoResponseMapper.toDto(
                shoppingCartService.getByUser(user));
    }
}
