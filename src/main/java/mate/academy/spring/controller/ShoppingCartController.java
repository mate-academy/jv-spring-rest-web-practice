package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
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
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;
    private UserService userService;
    private MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
                                          responseMapper,
                                  UserService userService,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        ShoppingCart shoppingCart = shoppingCartService.getByUser(userService.get(userId));
        return responseMapper.toDto(shoppingCart);
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto add(@RequestParam Long userId,
                                       @RequestParam Long movieSessionId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        shoppingCartService.addSession(movieSessionService.get(movieSessionId), user);
        return responseMapper.toDto(shoppingCart);
    }
}
