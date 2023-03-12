package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.TicketService;
import mate.academy.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShoppingCartRequestMapper
        implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final TicketService ticketService;
    private final UserService userService;

    @Autowired
    public ShoppingCartRequestMapper(TicketService ticketService, UserService userService) {
        this.ticketService = ticketService;
        this.userService = userService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setUser(userService.get(shoppingCartRequestDto.getUserId()));
        shoppingCart.setTickets(shoppingCartRequestDto.getTicketIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList()));
        return shoppingCart;
    }
}
