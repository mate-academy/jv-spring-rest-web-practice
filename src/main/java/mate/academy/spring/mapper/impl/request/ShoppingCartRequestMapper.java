package mate.academy.spring.mapper.impl.request;

import java.util.stream.Collectors;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.ShoppingCart;
import mate.academy.spring.model.dto.request.ShoppingCartRequestDto;
import mate.academy.spring.service.ShoppingCartService;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapper implements DtoRequestMapper<ShoppingCartRequestDto, ShoppingCart> {
    private UserService userService;
    private ShoppingCartService shoppingCartService;

    public ShoppingCartRequestMapper(UserService userService, ShoppingCartService shoppingCartService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
    }

    @Override
    public ShoppingCart fromDto(ShoppingCartRequestDto dto) {
      ShoppingCart shoppingCart = new ShoppingCart();
      shoppingCart.setUser(userService.get(dto.getUserId()));
      shoppingCart.setTickets(dto.getTickets().stream()
              .map(v -> shoppingCartService.getByUser(userService.get(
                      dto.getUserId())).getTickets().get(v.intValue()))
              .collect(Collectors.toList()));
      return shoppingCart;
    }
}
