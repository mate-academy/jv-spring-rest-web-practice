package mate.academy.spring.controller;

import mate.academy.spring.mapper.impl.request.MovieSessionRequestMapper;
import mate.academy.spring.mapper.impl.request.UserRequestDtoMapper;
import mate.academy.spring.mapper.impl.response.ShoppingCartResponseDtoMapper;
import mate.academy.spring.model.dto.request.MovieSessionRequestDto;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final MovieSessionRequestMapper movieSessionRequestMapper;
    private final ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper;
    private final UserRequestDtoMapper userRequestDtoMapper;
    private final UserService userService;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  MovieSessionRequestMapper movieSessionRequestMapper,
                                  ShoppingCartResponseDtoMapper shoppingCartResponseDtoMapper,
                                  UserRequestDtoMapper userRequestDtoMapper,
                                  UserService userService) {
        this.shoppingCartService = shoppingCartService;
        this.movieSessionRequestMapper = movieSessionRequestMapper;
        this.shoppingCartResponseDtoMapper = shoppingCartResponseDtoMapper;
        this.userRequestDtoMapper = userRequestDtoMapper;
        this.userService = userService;
    }

    @PutMapping("/movie-sessions")
    public void addMovieSession(@RequestBody MovieSessionRequestDto movieSessionRequestDto,
                                @RequestBody UserRequestDto userRequestDto) {
        shoppingCartService.addSession(movieSessionRequestMapper.fromDto(movieSessionRequestDto),
                userRequestDtoMapper.fromDto(userRequestDto));
    }

    @GetMapping("/by-user")
    private ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return shoppingCartResponseDtoMapper.toDto(shoppingCartService
                .getByUser(userService.get(userId)));
    }
}
