package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import mate.academy.spring.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart>
            shoppingCartDtoRequestMapper;
    private final UserService userService;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;
    private final OrderService orderService;

    public OrderController(DtoRequestMapper<ShoppingCartRequestDto,
            ShoppingCart> shoppingCartDtoRequestMapper,
                           UserService userService,
                           DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper,
                           OrderService orderService) {
        this.shoppingCartDtoRequestMapper = shoppingCartDtoRequestMapper;
        this.userService = userService;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
        this.orderService = orderService;
    }

    @PostMapping("/complete")
    public OrderResponseDto completeOrder(@RequestParam @Valid Long id,
                                          @RequestBody @Valid
                                          ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = shoppingCartDtoRequestMapper.fromDto(shoppingCartRequestDto);
        shoppingCart.setId(id);
        shoppingCart.setUser(userService.get(id));
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));
    }

    @GetMapping
    public List<OrderResponseDto> getOrderHistory(@RequestParam @Valid Long id) {
        return orderService.getOrdersHistory(userService.get(id)).stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
