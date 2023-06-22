package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoppingCarts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<
            ShoppingCartResponseDto, ShoppingCart> shoppingCartDtoResponseMapper;
    private final MovieSessionService movieSessionService;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> shoppingCartDtoResponseMapper,
                                  OrderService orderService,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartDtoResponseMapper.toDto(
                shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
                                @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(
                movieSessionId), userService.get(userId));
    }
}
