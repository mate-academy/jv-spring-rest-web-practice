package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsID;
    private LocalDateTime orderDate;
    private Long userId;

    public OrderResponseDto(Long id, List<Long> ticketsID, LocalDateTime orderDate, Long userId) {
        this.id = id;
        this.ticketsID = ticketsID;
        this.orderDate = orderDate;
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsID() {
        return ticketsID;
    }

    public void setTicketsID(List<Long> ticketsID) {
        this.ticketsID = ticketsID;
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
