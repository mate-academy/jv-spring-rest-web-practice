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
        user.setId(dto.getUserId());
        shoppingCart.setUser(user);
        List<Ticket> tickets = new ArrayList<>();
        for (Long l : dto.getTicketIds()) {
            Ticket tkt = new Ticket();
            tkt.setId(l);
            tickets.add(tkt);
        }
        shoppingCart.setTickets(tickets);
        return null;
    }
}
