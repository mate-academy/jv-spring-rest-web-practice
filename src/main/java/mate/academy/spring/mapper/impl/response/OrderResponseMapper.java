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
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        List<Ticket> tickets = object.getTickets();
        List<Long> ticketsId = tickets.stream()
                .map(t -> t.getId())
                .collect(Collectors.toList());
        orderResponseDto.setId(object.getId());
        orderResponseDto.setOrderDate(object.getOrderDate());
        orderResponseDto.setTicketsId(ticketsId);
        orderResponseDto.setUserId(object.getUser().getId());
        return orderResponseDto;
    }
}
