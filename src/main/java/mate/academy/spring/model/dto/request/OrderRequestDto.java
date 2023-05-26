package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Long> ticketsId;
    private LocalDateTime orderDate;

    public OrderRequestDto() {
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> tickets) {
        this.ticketsId = tickets;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

}
