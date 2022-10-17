package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setTicketsId(order.getTickets().stream()
                .map(ticket -> ticket.getId())
                .collect(Collectors.toList()));
        responseDto.setLocalDateTime(order.getOrderDate());
        responseDto.setUserId(order.getUser().getId());
        return responseDto;
    }
}
