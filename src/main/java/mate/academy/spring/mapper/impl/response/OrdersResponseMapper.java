package mate.academy.spring.mapper.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.OrdersResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrdersResponseMapper implements DtoResponseMapper<OrdersResponseDto, Order> {
    @Override
    public OrdersResponseDto toDto(Order order) {
        OrdersResponseDto ordersResponseDto = new OrdersResponseDto();
        ordersResponseDto.setId(order.getId());
        ordersResponseDto.setUserId(order.getUser().getId());
        ordersResponseDto.setOrderDate(order.getOrderDate());
        ordersResponseDto.setTicketIds(order.getTickets()
                .stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        return ordersResponseDto;
    }
}
