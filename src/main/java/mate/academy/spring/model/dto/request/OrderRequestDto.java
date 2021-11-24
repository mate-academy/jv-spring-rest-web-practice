package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Long> ticketIdList;
    private Long userId;
    private LocalDateTime orderDate;

    public List<Long> getTicketIdList() {
        return ticketIdList;
    }

    public void setTicketIdList(List<Long> ticketIdList) {
        this.ticketIdList = ticketIdList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
