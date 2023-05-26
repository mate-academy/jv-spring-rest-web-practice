package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.Order;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.OrderRequestDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderRequestMapper implements DtoRequestMapper<OrderRequestDto, Order> {
    @Override
    public Order fromDto(OrderRequestDto dto) {
        List<Ticket> tickets = new ArrayList<>();
        for (Long id: dto.getTicketsId()) {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            tickets.add(ticket);
        }
        Order order = new Order();
        order.setOrderDate(dto.getOrderDate());
        order.setTickets(tickets);
        return order;
    }
}
