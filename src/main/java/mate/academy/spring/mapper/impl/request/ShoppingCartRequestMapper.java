package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestDto,
        ShoppingCart> {
    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto shoppingCartRequestDto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setId(shoppingCartRequestDto.getUserId());
        shoppingCart.setUser(new User(shoppingCartRequestDto.getUserId()));
        shoppingCart.setTickets(shoppingCartRequestDto.getTicketIds().stream()
                .map(Ticket::new)
                .collect(Collectors.toList()));
        return shoppingCart;
    }
}
