package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.spring.model.Ticket;

@Getter
@Setter
public class OrderRequestDto {
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    private Long userId;
}
