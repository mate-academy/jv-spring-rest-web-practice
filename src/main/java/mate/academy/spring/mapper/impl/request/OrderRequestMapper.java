package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
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
        List<Ticket> tickets = new ArrayList<>();
        for (Long id : dto.getTicketsId()) {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            tickets.add(ticket);
        }
        order.setTickets(tickets);
        order.setOrderDate(dto.getOrderDate());
        User user = new User();
        user.setId(dto.getUserId());
        order.setUser(user);
        return order;
    }
}
