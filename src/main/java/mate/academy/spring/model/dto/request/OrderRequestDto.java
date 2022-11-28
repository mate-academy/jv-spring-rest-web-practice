package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class OrderRequestDto {
    @NotNull
    @Min(value = 1)
    private List<Long> ticketIds;
    @NotNull
    private LocalDateTime orderDate;
    @NotNull
    @Min(value = 1)
    private Long userId;

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
