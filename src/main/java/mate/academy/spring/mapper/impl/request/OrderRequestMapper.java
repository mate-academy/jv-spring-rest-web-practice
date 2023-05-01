package mate.academy.spring.mapper.impl.request;

import java.time.LocalDateTime;
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
        Order obj = new Order();
        User user = new User();
        user.setId(dto.getUserId());
        obj.setUser(user);
        List<Ticket> tickets = new ArrayList<>();
        for (Long l : dto.getTicketIds()) {
            Ticket tkt = new Ticket();
            tkt.setId(l);
            tickets.add(tkt);
        }
        obj.setTickets(tickets);
        obj.setOrderDate(LocalDateTime.now());
        return obj;
    }
}
