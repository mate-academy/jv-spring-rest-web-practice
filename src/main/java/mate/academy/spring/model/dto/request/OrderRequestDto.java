package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Integer> ticketsIds;
    private LocalDateTime orderDate;
    private Long userId;

    public List<Integer> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Integer> ticketsIds) {
        this.ticketsIds = ticketsIds;
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
