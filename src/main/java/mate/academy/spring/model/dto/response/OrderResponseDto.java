package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private LocalDateTime orderDate;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
