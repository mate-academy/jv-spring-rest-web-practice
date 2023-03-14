package mate.academy.spring.mapper.impl.request;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements
        DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private UserService userService;
    private TicketDao ticketDao;

    @Autowired
    public ShoppingCartRequestMapper(UserService userService, TicketDao ticketDao) {
        this.userService = userService;
        this.ticketDao = ticketDao;
    }

    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(dto.getUserId()));
        List<Ticket> tickets = new ArrayList<>();
        tickets.stream()
                .map(ticket -> ticket = ticketDao.get(dto.getUserId()).get())
                .collect(Collectors.toList());
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
