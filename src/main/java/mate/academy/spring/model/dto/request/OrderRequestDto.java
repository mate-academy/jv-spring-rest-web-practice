package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;
import lombok.Data;
import mate.academy.spring.model.Ticket;

@Data
public class OrderRequestDto {
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    @NotNull
    private Long userId;
}
