package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;
import mate.academy.spring.model.Ticket;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<Ticket> tickets;
    private Long userId;
}
