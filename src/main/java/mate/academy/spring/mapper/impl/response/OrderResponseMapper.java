package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponceDto = new OrderResponseDto();
        orderResponceDto.setId(order.getId());
        orderResponceDto.setOrderDate(order.getOrderDate());
        orderResponceDto.setTickets(order.getTickets());
        orderResponceDto.setUserId(order.getUser().getId());
        return orderResponceDto;
    }
}
