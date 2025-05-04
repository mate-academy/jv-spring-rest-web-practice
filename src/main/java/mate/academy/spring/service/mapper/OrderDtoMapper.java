package mate.academy.spring.service.mapper;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderDtoMapper {
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setId(order.getId());
        orderResponseDto.setTickets(order.getTickets());
        orderResponseDto.setUser(order.getUser());
        return orderResponseDto;
    }

    public Order toModel(OrderResponseDto orderResponseDto) {
        Order order = new Order();
        order.setId(orderResponseDto.getId());
        order.setOrderDate(orderResponseDto.getOrderDate());
        order.setTickets(orderResponseDto.getTickets());
        order.setUser(orderResponseDto.getUser());
        return order;
    }
}
