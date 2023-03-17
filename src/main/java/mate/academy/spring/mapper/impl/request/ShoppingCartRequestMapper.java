package mate.academy.spring.mapper.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public ShoppingCartRequestMapper(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        List<Ticket> tickets = shoppingCartRequestDto.getTicketsIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList());

        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(tickets);
        shoppingCart.setUser(userService.get(shoppingCartRequestDto.getUserId()));
        return shoppingCart;
    }
}
