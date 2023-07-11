package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestDto implements
        DtoRequestMapper<mate.academy.spring.model.dto.request.ShoppingCartRequestDto,
                ShoppingCart> {
    @Override
    public ShoppingCart fromDto(mate.academy.spring.model.dto.request.ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = new User();
        user.setId(dto.getUserId());
        shoppingCart.setUser(user);
        List<Ticket> tickets = new ArrayList<>();
        dto.getTickets().forEach(t -> {
            Ticket ticket = new Ticket();
            ticket.setId(t);
            tickets.add(ticket);
        });
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
