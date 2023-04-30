package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShopingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final DtoResponseMapper<ShopingCartResponseDto, ShoppingCart> shoppingCartDtoResponseMapper;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;

    public ShoppingCartController(DtoResponseMapper<ShopingCartResponseDto,
            ShoppingCart> shoppingCartDtoResponseMapper,
                                  ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @PutMapping("/movie-sessions")
    public ShopingCartResponseDto update(@RequestParam Long userId,
                                                  @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), userService.get(userId));
        return shoppingCartDtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping("/by-user")
    public ShopingCartResponseDto getByUserId(@PathVariable Long userId) {
        return shoppingCartDtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
