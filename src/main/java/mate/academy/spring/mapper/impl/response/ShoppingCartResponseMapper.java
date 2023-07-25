package mate.academy.spring.mapper.impl.response;

import java.util.ArrayList;
import java.util.List;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto toDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(shoppingCart.getId());
        List<Long> ticketIds = new ArrayList<>();
        shoppingCart.getTickets().forEach(t -> ticketIds.add(t.getId()));
        responseDto.setTicketIds(ticketIds);
        responseDto.setUserId(shoppingCart.getUser().getId());
        return responseDto;
    }
}
