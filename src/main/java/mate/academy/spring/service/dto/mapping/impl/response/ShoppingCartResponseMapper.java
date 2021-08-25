package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.stream.Collectors;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.dto.response.ShoppingCcartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements DtoResponseMapper<ShoppingCcartResponseDto,
        ShoppingCart> {

    @Override
    public ShoppingCcartResponseDto toDto(ShoppingCart cart) {
        return new ShoppingCcartResponseDto(cart.getId(), cart.getTickets().stream()
                .map(Ticket::getId)
                .collect(Collectors.toList()));
    }
}
