package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private long id;
    private List<Long> ticketsId;
    private LocalDateTime orderDate;
    private long userId;
}
