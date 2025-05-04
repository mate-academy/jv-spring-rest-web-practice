package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseDtoMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate());
        responseDto.setTicketsIds(order.getTickets()
                .stream()
                .map(ticket -> ticket.getId())
                .collect(Collectors.toList()));
        responseDto.setUserID(order.getUser().getId());
        return responseDto;
    }
}
