package mate.academy.spring.service.dto.mapping.impl.response;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.model.dto.response.TicketResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    private TicketsResponseMapper ticketsResponseMapper;

    public OrderResponseMapper(TicketsResponseMapper ticketsResponseMapper) {
        this.ticketsResponseMapper = ticketsResponseMapper;
    }

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setOrderDate(LocalDateTime.now());
        orderResponseDto.setUserId(order.getUser().getId());
        List<TicketResponseDto> tickets = order.getTickets().stream()
                .map(ticketsResponseMapper::toDto)
                .collect(Collectors.toList());
        orderResponseDto.setTickets(tickets);
        return orderResponseDto;
    }
}
