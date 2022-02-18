package mate.academy.spring.model.dto.request;

import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import mate.academy.spring.model.Ticket;

public class OrderRequestDto {
    @NotNull
    private List<Ticket> tickets;
    @NotNull
    private LocalDateTime orderDate;
    @NotNull
    private Long userId;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
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
