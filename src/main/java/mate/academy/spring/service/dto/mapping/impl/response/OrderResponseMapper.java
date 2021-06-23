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
    public OrderResponseDto toDto(Order object) {
        OrderResponseDto response = new OrderResponseDto();
        response.setId(object.getId());
        response.setOrderDate(String.valueOf(object.getOrderDate()));
        response.setTicketsId(object.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        response.setUserId(object.getUser().getId());
        return response;
    }
}
