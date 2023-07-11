package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shoping-cart")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
            shoppingCartDtoResponseMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
              DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart>
              shoppingCartDtoResponseMapper) {
        this.shoppingCartService = shoppingCartService;
        this.shoppingCartDtoResponseMapper = shoppingCartDtoResponseMapper;
    }

    @GetMapping("by-user")
    public ShoppingCartResponseDto get(@RequestParam("userId") Long id) {
        User user = new User();
        user.setId(id);
        return shoppingCartDtoResponseMapper.toDto(shoppingCartService.getByUser(user));
    }

    @PutMapping("/movie-sessions")
    public void update(@RequestParam("movieSessionId") Long movieSessionId,
                       @RequestParam("userId") Long userId) {
        User user = new User();
        user.setId(userId);
        MovieSession movieSession = new MovieSession();
        movieSession.setId(movieSessionId);
        shoppingCartService.addSession(movieSession, user);
    }
}
