package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import mate.academy.spring.model.User;

public class OrderRequestDto {
    private List<Long> ticketsId;
    private LocalDateTime orderDate;
    private User user;

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
