package mate.academy.spring.model.dto.request;

import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

import java.time.LocalDateTime;
import java.util.List;

public class OrderRequestDto {
    private List<Ticket> tickets;
    private LocalDateTime orderDate;
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
