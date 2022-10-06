package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.response.ShoppingCartResponseMapper;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final ShoppingCartResponseMapper responseMapper;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  ShoppingCartResponseMapper responseMapper,
                                  MovieSessionService movieSessionService) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.responseMapper = responseMapper;
        this.movieSessionService = movieSessionService;
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto get(@RequestParam Long userId) {
        return responseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

    @PutMapping("/movie-sessions")
    @ResponseStatus(HttpStatus.CREATED)
    public void addSession(@RequestParam(name = "userId") Long usrId,
                           @RequestParam(name = "movieSessionId") Long movieSessionId) {
        shoppingCartService.addSession(movieSessionService.get(movieSessionId),
                userService.get(usrId));
    }
}
