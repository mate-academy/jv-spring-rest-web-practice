package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Long> ticketsIs;
    private LocalDateTime orderDate;
    private Long userId;

    public List<Long> getTicketsIs() {
        return ticketsIs;
    }

    public void setTicketsIs(List<Long> ticketsIs) {
        this.ticketsIs = ticketsIs;
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
