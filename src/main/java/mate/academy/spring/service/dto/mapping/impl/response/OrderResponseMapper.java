package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Service;

@Service
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order entity) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(entity.getId());
        orderResponseDto.setTicketIds(entity.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setUserId(entity.getUser().getId());
        orderResponseDto.setOrderDate(entity.getOrderDate());
        return orderResponseDto;
    }
}
