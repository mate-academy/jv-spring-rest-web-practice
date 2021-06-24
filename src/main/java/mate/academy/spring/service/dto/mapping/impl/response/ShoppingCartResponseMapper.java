package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.response.ShoppingCartResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseMapper implements
        DtoResponseMapper<ShoppingCartResponseDto, ShoppingCart> {
    @Override
    public ShoppingCartResponseDto parseToDto(ShoppingCart cart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setId(cart.getId());
        responseDto.setTickets(cart.getTickets());
        responseDto.setUserId(cart.getUser().getId());
        return responseDto;
    }
}
