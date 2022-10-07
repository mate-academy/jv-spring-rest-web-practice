package mate.academy.spring.model.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    @JsonProperty("ticketsId")
    private List<Long> ticketsId;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime orderDate;
    private Long userId;

    public List<Long> getTicketId() {
        return ticketsId;
    }

    public void setTicketId(List<Long> ticketId) {
        this.ticketsId = ticketId;
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
