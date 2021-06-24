package mate.academy.spring.model.dto.request;

import jakarta.validation.constraints.NotNull;
import java.util.List;
import lombok.Data;
import mate.academy.spring.model.Ticket;

@Data
public class ShoppingCartRequestDto {
    private List<Ticket> tickets;
    @NotNull
    private Long userId;
}
