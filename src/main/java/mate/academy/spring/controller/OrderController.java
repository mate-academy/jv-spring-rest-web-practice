package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.MovieSessionService;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoResponseMapper<OrderResponseDto, Order> responseMapper;
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public OrderController(OrderService orderService,
                           DtoResponseMapper<OrderResponseDto, Order> responseMapper,
                           UserService userService,
                           ShoppingCartService shoppingCartService) {
        this.orderService = orderService;
        this.responseMapper = responseMapper;
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam Long userId) {
        User user = userService.get(userId);
        ShoppingCart shoppingCart = shoppingCartService.getByUser(user);
        return responseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    private List<OrderResponseDto> getOrderHistory(@RequestParam Long userId) {
        User user = userService.get(userId);
        return orderService.getOrdersHistory(user).stream()
                .map(responseMapper::toDto)
                .collect(Collectors.toList());
    }

    @RestController
    @RequestMapping("/shopping-carts")
    public static class ShoppingCartsController {
        private final ShoppingCartService shoppingCartService;
        private final UserService userService;
        private final MovieSessionService movieSessionService;
        private final DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> responseMapper;

        @Autowired
        public ShoppingCartsController(ShoppingCartService shoppingCartService,
                                       UserService userService,
                                       MovieSessionService movieSessionService,
                                       DtoResponseMapper<ShoppingCartResponseDto,
                                               ShoppingCart> responseMapper) {
            this.shoppingCartService = shoppingCartService;
            this.userService = userService;
            this.movieSessionService = movieSessionService;
            this.responseMapper = responseMapper;
        }

        @GetMapping("/by-user")
        public ShoppingCartResponseDto getByUserId(@RequestParam Long userId) {
            User user = userService.get(userId);
            return responseMapper.toDto(shoppingCartService.getByUser(user));
        }

        @PutMapping("/movie-sessions")
        public void addMovieSession(@RequestParam Long userId,
                                    @RequestParam Long movieSessionId) {
            shoppingCartService.addSession(movieSessionService
                    .get(movieSessionId), userService.get(userId));
        }
    }
}
