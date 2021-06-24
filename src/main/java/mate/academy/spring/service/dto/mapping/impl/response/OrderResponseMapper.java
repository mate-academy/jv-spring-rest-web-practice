package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper {
    public OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(
                order.getId(),
                order.getTickets().stream().map(Ticket::getId).collect(Collectors.toList()),
                order.getOrderDate(),
                order.getUser().getId());
    }
}
