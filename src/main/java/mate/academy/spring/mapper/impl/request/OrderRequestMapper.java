package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {

    @Override
    public Order fromDto(OrderRequestDto orderRequestDto) {
        Order order = new Order();
        order.setTickets(orderRequestDto.getTicketIds().stream()
                .map(Ticket::new)
                .collect(Collectors.toList())
        );
        order.setOrderDate(orderRequestDto.getOrderDate());
        order.setUser(new User(orderRequestDto.getUserId()));
        return order;
    }
}
