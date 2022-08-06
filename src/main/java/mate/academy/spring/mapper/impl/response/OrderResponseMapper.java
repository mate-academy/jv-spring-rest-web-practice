package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.model.User;
import java.time.LocalDateTime;
import java.util.List;

public class OrderResponseMapper {
    private Long id;
    private List<Integer> tickets;
    private LocalDateTime orderDate;
    private User userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Integer> getTickets() {
        return tickets;
    }

    public void setTickets(List<Integer> tickets) {
        this.tickets = tickets;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
