package mate.academy.spring.service.dto.mapping.impl.response;

import java.util.ArrayList;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {

    @Override
     public ShoppingCartResponseDto toDto(ShoppingCart shoppCart) {
        ShoppingCartResponseDto dto = new ShoppingCartResponseDto();
        dto.setUserId(shoppCart.getUser().getId());
        dto.setTicketIds(new ArrayList<>());
        shoppCart.getTickets()
                .forEach(t -> dto.getTicketIds()
                       .add(t.getId()));
        return dto;
    }
}
