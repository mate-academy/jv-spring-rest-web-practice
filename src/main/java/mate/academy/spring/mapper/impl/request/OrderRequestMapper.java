package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<Order, OrderRequestDto> {
    @Override
    public OrderRequestDto fromDto(Order order) {
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderDate(order.getOrderDate());
        orderRequestDto.setTickets(order.getTickets());
        orderRequestDto.setUserId(order.getUser().getId());
        return orderRequestDto;
    }
}
