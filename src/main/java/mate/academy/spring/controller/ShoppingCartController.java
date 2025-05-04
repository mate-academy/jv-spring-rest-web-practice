package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
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
@RequestMapping("/shopping-cart")
public class ShoppingCartController {
    private DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;
    private ShoppingCartService shoppingCartService;
    private MovieSessionService movieSessionService;
    private UserService userService;

    public ShoppingCartController(DtoResponseMapper<ShoppingCartResponseDto,
            ShoppingCart> responseMapper,
                                  ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  UserService userService) {
        this.responseMapper = responseMapper;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.userService = userService;
    }

    @PutMapping("/movie-session")
    public void addSession(@RequestParam Long movieSessionId,
                           @RequestParam Long userId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(userId));
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
