package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto,Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto response = new OrderResponseDto();
        response.setId(order.getId());
        response.setOrderDate(String.valueOf(order.getOrderDate()));
        response.setTicketsId(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        response.setUserId(order.getUser().getId());
        return response;
    }
}
