package mate.academy.spring.controller;

import lombok.AllArgsConstructor;
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
@RequestMapping("/shopping-carts")
@AllArgsConstructor
public class ShoppingCartController {
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseMapper;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                                   @RequestParam Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService
                .get(movieSessionId), userService.get(userId));
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @GetMapping( "/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }
}
