package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import mate.academy.spring.model.User;

@Getter
@Setter
public class OrderResponseDto {
    private List<Long> ticketId;
    private LocalDateTime orderDate;
    private User user;
}
