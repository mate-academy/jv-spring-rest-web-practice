package mate.academy.spring.mapper.impl.response;

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
        object.getTickets()
                .stream()
                .map(Ticket::getId)
                .forEach(orderResponseDto.getTicketIds()::add);
        orderResponseDto.setOrderDate(object.getOrderDate());
        orderResponseDto.setUserId(object.getUser().getId());
        return orderResponseDto;
    }
}
