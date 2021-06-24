package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long orderId;
    private List<Long> tickets;
    private LocalDateTime orderDate;
    private Long userId;
}
