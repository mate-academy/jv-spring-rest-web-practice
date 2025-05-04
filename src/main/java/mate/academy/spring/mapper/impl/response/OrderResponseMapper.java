package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        List<Long> ticketsIds = new ArrayList<>();
        order.getTickets().stream()
                .mapToLong(Ticket::getId)
                .forEach(ticketsIds::add);
        OrderResponseDto dto = new OrderResponseDto();
        dto.setTicketsIds(ticketsIds);
        dto.setId(order.getId());
        return dto;
    }
}
