package mate.academy.spring.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class OrderResponseDto {
    private Long id;
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    private User user;
}
