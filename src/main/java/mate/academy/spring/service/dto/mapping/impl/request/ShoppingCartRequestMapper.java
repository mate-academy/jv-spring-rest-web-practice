package mate.academy.spring.service.dto.mapping.impl.request;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestDto,
        ShoppingCart> {
    private final UserService userService;
    private final TicketDao ticketDao;

    public ShoppingCartRequestMapper(UserService userService, TicketDao ticketDao) {
        this.userService = userService;
        this.ticketDao = ticketDao;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(dto.getUserId()));
        List<Ticket> ticketList = dto.getTicketsId()
                .stream()
                .map(ticketDao::get)
                .collect(Collectors.toList());
        shoppingCart.setTickets(ticketList);
        return shoppingCart;
    }
}
