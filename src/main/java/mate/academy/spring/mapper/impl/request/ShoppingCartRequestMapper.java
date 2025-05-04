package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private UserService userService;
    private TicketService ticketService;

    public ShoppingCartRequestMapper(UserService userService, TicketService ticketService) {
        this.userService = userService;
        this.ticketService = ticketService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        List<Ticket> tickets = dto.getTicketIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList());
        shoppingCart.setTickets(tickets);
        User user = userService.get(dto.getUserId());
        shoppingCart.setUser(user);
        return shoppingCart;
    }
}
