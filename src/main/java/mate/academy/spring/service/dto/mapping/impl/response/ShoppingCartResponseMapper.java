package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart object) {
        ShoppingCartResponseDto shoppingCart = new ShoppingCartResponseDto();
        shoppingCart.setId(object.getId());
        shoppingCart.setTicketsId(object.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
        shoppingCart.setUserId(object.getUser().getId());
        return shoppingCart;
    }
}
