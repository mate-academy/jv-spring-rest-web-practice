package mate.academy.spring.mapper.impl.request;

import java.util.List;
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
    public Order fromDto(OrderRequestDto dto) {
        Order order = new Order();
        User user = new User();
        user.setId(dto.getUserId());
        List<Ticket> tickets = dto.getTicketsId().stream()
                .map(Ticket::new)
                .collect(Collectors.toList());
        order.setUser(user);
        order.setTickets(tickets);
        order.setOrderDate(dto.getOrderDate());
        return order;
    }
}
