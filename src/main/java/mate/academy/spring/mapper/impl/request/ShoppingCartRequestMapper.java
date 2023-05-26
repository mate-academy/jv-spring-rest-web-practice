package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper
          implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final UserService userService;

    public ShoppingCartRequestMapper(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        List<Ticket> tickets = new ArrayList<>();
        for (Long id: dto.getTicketsId()) {
            Ticket ticket = new Ticket();
            ticket.setId(id);
            tickets.add(ticket);
        }
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
