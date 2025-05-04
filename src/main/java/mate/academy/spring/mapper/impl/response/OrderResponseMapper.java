package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {
    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto responseDto = new OrderResponseDto();
        responseDto.setId(order.getId());
        responseDto.setOrderDate(order.getOrderDate());
        List<Long> ticketIds = new ArrayList<>();
        order.getTickets().forEach(t -> ticketIds.add(t.getId()));
        responseDto.setTicketIds(ticketIds);
        responseDto.setUserId(order.getUser().getId());
        return responseDto;
    }
}
