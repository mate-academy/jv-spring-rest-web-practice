package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long orderId;
    private List<Long> ticketsId;
    private LocalDateTime orderDate;
    private Long userId;

    public Long getOrderId() {
        return orderId;
    }

    public OrderResponseDto setOrderId(Long orderId) {
        this.orderId = orderId;
        return this;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public OrderResponseDto setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderResponseDto setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }

    public Long getUserId() {
        return userId;
    }

    public OrderResponseDto setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
