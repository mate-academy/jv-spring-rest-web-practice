package mate.academy.spring.model.dto.request;

import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import mate.academy.spring.model.Ticket;

@Data
public class ShoppingCartRequestDto {
    private List<Ticket> tickets;
    @NotNull
    private Long userId;
}
