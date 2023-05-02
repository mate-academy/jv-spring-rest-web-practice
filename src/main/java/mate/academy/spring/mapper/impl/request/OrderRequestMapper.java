package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;

public class OrderRequestMapper {
    public Order fromDto(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setUser(orderRequestDto.getUser());
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setTickets(orderRequestDto.getTickets());
        return order;
    }
}
