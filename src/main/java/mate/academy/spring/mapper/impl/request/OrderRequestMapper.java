package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    @Override
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        order.setId(dto.getId());
        order.setTickets(dto.getTickets());
        order.setOrderDate(dto.getOrderDate());
        order.setUser(dto.getUser());
        return order;
    }
}
