package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<
        ShoppingCartRequestDto, ShoppingCart> {
    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(new User(dto.getUserId()));
        List<Ticket> tickets = new ArrayList<>();
        for (Long ticketId : dto.getTicketsId()) {
            Ticket ticket = new Ticket();
            ticket.setId(ticketId);
            tickets.add(ticket);
        }
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
