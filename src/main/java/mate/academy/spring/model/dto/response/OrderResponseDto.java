package mate.academy.spring.model.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import mate.academy.spring.model.User;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private LocalDateTime orderDate;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
