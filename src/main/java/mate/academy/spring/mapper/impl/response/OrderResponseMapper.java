package mate.academy.spring.mapper.impl.response;

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
        orderResponseDto.setId(object.getId());
        orderResponseDto.setTicketIds(object.getTickets().stream()
                .map(Ticket::getId).collect(Collectors.toList()));
        orderResponseDto.setUserId(object.getUser().getId());
        orderResponseDto.setOrderDate(object.getOrderDate());
        return orderResponseDto;
    }
}
