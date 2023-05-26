package mate.academy.spring.controller;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final UserService userService;
    private final MovieSessionService movieSessionService;
    private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> dtoResponseMapper;
    private final DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> dtoRequestMapper;

    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  UserService userService,
                                  MovieSessionService movieSessionService,
                                  DtoResponseMapper<ShoppingCartResponseDto,
                                          ShoppingCart> dtoResponseMapper,
                                  DtoRequestMapper<ShoppingCartRequestDto,
                                          ShoppingCart> dtoRequestMapper) {
        this.shoppingCartService = shoppingCartService;
        this.userService = userService;
        this.movieSessionService = movieSessionService;
        this.dtoResponseMapper = dtoResponseMapper;
        this.dtoRequestMapper = dtoRequestMapper;
    }

    @PutMapping("/movie-sessions")
    public ShoppingCartResponseDto addMovieSession(@RequestParam Long userId,
                                        @RequestParam Long movieSessionId,
                                        @RequestBody ShoppingCartRequestDto requestDto) {
        List<Ticket> tickets = new ArrayList<>();
        for (Long id: requestDto.getTicketsId()) {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            tickets.add(ticket);
        }
        MovieSession movieSession = movieSessionService.get(movieSessionId);
        User user = userService.get(userId);
        ShoppingCart shoppingCart = dtoRequestMapper.fromDto(requestDto);
        shoppingCart.setUser(user);
        shoppingCart.setTickets(tickets);
        shoppingCartService.addSession(movieSession, user);
        return dtoResponseMapper.toDto(shoppingCart);
    }

    @GetMapping("/by-user")
    public ShoppingCartResponseDto getByUser(@RequestParam Long userId) {
        return dtoResponseMapper.toDto(shoppingCartService.getByUser(userService.get(userId)));
    }

}
