package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

@Data
public class OrderResponseDto {
    private Long id;
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    private User user;
}
