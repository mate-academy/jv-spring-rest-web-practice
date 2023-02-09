package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.dao.TicketDao;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.UserService;
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

    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(dto.getUserId());
        shoppingCart.setTickets(dto.getTicketsIds().stream()
                .map(id -> ticketDao.get(id).get())
                .collect(Collectors.toList()));
        shoppingCart.setUser(userService.get(dto.getUserId()));
        return shoppingCart;
    }
}
