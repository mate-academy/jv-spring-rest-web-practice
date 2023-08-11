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
    private UserService userService;
    private TicketDao ticketDao;

    public ShoppingCartRequestMapper(UserService userService, TicketDao ticketDao) {
        this.userService = userService;
        this.ticketDao = ticketDao;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(dto.getUserId()));
        shoppingCart.setId(dto.getUserId());
        shoppingCart.setTickets(dto.getTicketIds().stream()
                .map(id -> ticketDao.get(id).get())
                .collect(Collectors.toList()));
        return shoppingCart;
    }
}
