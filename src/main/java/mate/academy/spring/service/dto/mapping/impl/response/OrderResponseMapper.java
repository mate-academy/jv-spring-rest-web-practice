package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setTicketsIds(order.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        dto.setOrderTime(order.getOrderDate());
        dto.setUserId(order.getUser().getId());
        return dto;
    }
}
