package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private List<Long> ticketsId;
    private Long userId;
    private LocalDateTime orderDate;
}
