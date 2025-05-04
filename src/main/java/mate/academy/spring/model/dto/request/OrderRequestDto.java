package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Long> ticketIds;
    private LocalDateTime orderDate;

    public OrderRequestDto() {
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> tickets) {
        this.ticketIds = tickets;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

}
