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
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(object.getId());
        responseDto.setTicketsIds(object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        responseDto.setOrderDate(object.getOrderDate());
        responseDto.setUserId(object.getUser().getId());
        return responseDto;
    }
}
