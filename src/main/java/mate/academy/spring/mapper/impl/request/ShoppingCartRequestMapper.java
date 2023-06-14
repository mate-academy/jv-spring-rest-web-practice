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
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User();
        user.setId(dto.getId());
        shoppingCart.setId(dto.getId());
        shoppingCart.setUser(user);
        List<Ticket> tickets = new ArrayList<>();
        if (dto.getTicketId() != null) {
            for (Long ticketId : dto.getTicketId()) {
                Ticket ticket = new Ticket();
                ticket.setId(ticketId);
                tickets.add(ticket);
            }
        }
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
