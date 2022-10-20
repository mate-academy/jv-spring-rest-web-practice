package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
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
@RequestMapping("shopping-carts")
public class ShoppingCartController {
    private ShoppingCartService shoppingCartService;
    private DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartMapper;
    private UserService userService;
    private MovieSessionService movieSessionService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
            DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> shoppingCartMapper,
            UserService userService,
            MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartMapper = shoppingCartMapper;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
        return shoppingCartMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestParam Long userId,
            @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(
                movieSessionService.get(movieSessionId), userService.get(userId));
    }
}
