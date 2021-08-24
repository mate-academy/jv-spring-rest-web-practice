package mate.academy.spring.controller;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCcartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCcartResponseDto, ShoppingCart> dtoResponseMapper;

    public ShoppingCartController(UserService userService, ShoppingCartService shoppingCartService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCcartResponseDto,
                                          ShoppingCart> dtoResponseMapper) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.movieSessionService = movieSessionService;
        this.dtoResponseMapper = dtoResponseMapper;
    }

    @GetMapping("/by-user")
    public ShoppingCcartResponseDto getByUser(@RequestParam Long id) {
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.getById(id)));
    }

    @PostMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long id,
                                @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.getById(id));
    }
}
