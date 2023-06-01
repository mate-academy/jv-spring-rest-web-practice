package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketId;
    private LocalDateTime orderDate;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketId() {
        return ticketId;
    }

    public void setTicketsId(List<Long> ticketId) {
        this.ticketId = ticketId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
