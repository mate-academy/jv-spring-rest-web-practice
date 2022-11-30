package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.TicketService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper
        implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final TicketService ticketService;

    public ShoppingCartRequestMapper(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setTickets(dto.getTicketIds().stream()
                .map(ticketService::get)
                .collect(Collectors.toList()));
        return shoppingCart;
    }
}
