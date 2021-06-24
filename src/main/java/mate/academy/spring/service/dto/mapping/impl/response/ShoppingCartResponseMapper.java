package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper {
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        return new ShoppingCartResponseDto(
                shoppingCart.getId(),
                shoppingCart.getTickets()
                        .stream()
                        .map(Ticket::getId)
                        .collect(Collectors.toList()),
                shoppingCart.getId());
    }
}
