package mate.academy.spring.service.dto.mapping.impl.request;

import java.util.List;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper
        implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;

    public ShoppingCartRequestMapper(UserService userService,
                                     ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
        ShoppingCart shoppingCart = new ShoppingCart();
        User user = userService.get(dto.getUserId());
        List<Ticket> tickets = shoppingCartService.getByUser(user).getTickets();
        shoppingCart.setUser(user);
        shoppingCart.setTickets(tickets);
        return shoppingCart;
    }
}
