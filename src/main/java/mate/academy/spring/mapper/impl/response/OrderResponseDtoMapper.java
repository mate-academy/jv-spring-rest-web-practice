package mate.academy.spring.mapper.impl.response;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseDtoMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order model) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(model.getId());
        dto.setOrderDate(model.getOrderDate());
        List<Long> tickets = model.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList());
        dto.setTicketIds(tickets);
        dto.setUserId(model.getUser().getId());
        return dto;
    }
}
