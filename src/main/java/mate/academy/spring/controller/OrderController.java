package mate.academy.spring.controller;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final DtoRequestMapper<OrderRequestDto, Order> orderDtoRequestMapper;
    private final DtoResponseMapper<OrderResponseDto, Order> orderDtoResponseMapper;
    private final DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> shoppingCartDtoRequestMapper;

    public OrderController(OrderService orderService,
                           DtoRequestMapper<OrderRequestDto,
                                   Order> orderDtoRequestMapper,
                           DtoResponseMapper<OrderResponseDto,
                                   Order> orderDtoResponseMapper,
                           DtoRequestMapper<ShoppingCartRequestDto,
                                   ShoppingCart> shoppingCartDtoRequestMapper) {
        this.orderService = orderService;
        this.orderDtoRequestMapper = orderDtoRequestMapper;
        this.orderDtoResponseMapper = orderDtoResponseMapper;
        this.shoppingCartDtoRequestMapper = shoppingCartDtoRequestMapper;
    }

    @GetMapping("/orders/{userId}")
    public List<OrderResponseDto> getOrdersHistory(@PathVariable Long userId,
                                                   @RequestBody OrderRequestDto orderRequestDto) {
        Order order = orderDtoRequestMapper.fromDto(orderRequestDto);
        return orderService.getOrdersHistory(order.getUser())
                .stream()
                .map(orderDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping("/complete/{userId}")
    public OrderResponseDto complete(@PathVariable Long userId,
                                     @RequestBody ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = shoppingCartDtoRequestMapper.fromDto(shoppingCartRequestDto);
        return orderDtoResponseMapper.toDto(orderService.completeOrder(shoppingCart));

    }
}
