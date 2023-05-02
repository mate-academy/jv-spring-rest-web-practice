package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseDto {
    private Long id;
    private final List<Long> list;
    private List<Long> ticketIds;
    private LocalDateTime orderDate;
    private final Long id1;
    private Long userId;

    public OrderResponseDto(
            Long id,
            List<Long> list,
            LocalDateTime orderDate,
            Long id1
    ) {
        this.id = id;
        this.list = list;
        this.orderDate = orderDate;
        this.id1 = id1;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
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
