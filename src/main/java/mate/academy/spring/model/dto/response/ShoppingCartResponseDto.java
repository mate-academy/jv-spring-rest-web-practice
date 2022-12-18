package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import mate.academy.spring.model.Ticket;

@Getter
@Accessors(chain = true)
@Setter
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userId;
}
