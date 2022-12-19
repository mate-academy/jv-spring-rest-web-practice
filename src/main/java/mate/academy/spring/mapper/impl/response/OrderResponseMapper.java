package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.dto.response.OrderResponseDto;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

public class OrderResponseMapper implements DtoResponseMapper<OrderResponseDto, Order> {

    @Override
    public OrderResponseDto toDto(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setOrderDate(LocalDateTime.now());
        dto.setUserId(order.getUser().getId());
        dto.setTicketsId(order.getTickets()
                .stream()
                .map(t -> t.getId())
                .collect(Collectors.toList()));
        return dto;
    }
}
