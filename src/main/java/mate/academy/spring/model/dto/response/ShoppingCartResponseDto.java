package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private List<Ticket> tickets;
    private User user;
}
