package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import mate.academy.spring.model.Ticket;

@Data
public class OrderRequestDto {
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    private Long userId;
}
