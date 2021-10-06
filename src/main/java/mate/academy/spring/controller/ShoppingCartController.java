package mate.academy.spring.controller;

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
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    private final UserService userService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
            shoppingCartDtoResponseMapper;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(UserService userService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          shoppingCartDtoResponseMapper,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService) {
        this.userService = userService;
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/add")
    public ShoppingCartResponseDto add(@PathVariable Long userId, @PathVariable Long movieId) {
        shoppingCartService.addSession(movieSessionService.get(movieId), userService.get(userId));
        return shoppingCartDtoResponseMapper
                .toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping("/get-all")
    public ShoppingCartResponseDto getAll(@PathVariable Long userId) {
        return shoppingCartDtoResponseMapper
                .toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
