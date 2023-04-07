package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(object.getId());
        List<Long> ticketsId = object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketsId(ticketsId);
        dto.setOrderDate(object.getOrderDate());
        dto.setUserId(object.getUser().getId());
        return dto;
    }
}
