package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<Order, OrderRequestDto> {
    @Override
    public OrderRequestDto toModel(Order order) {
        OrderRequestDto orderRequestDto = new OrderRequestDto();
        orderRequestDto.setOrderDate(order.getOrderDate());
        orderRequestDto.setTicketId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderRequestDto.setUserId(order.getUser().getId());
        return orderRequestDto;
    }
}
