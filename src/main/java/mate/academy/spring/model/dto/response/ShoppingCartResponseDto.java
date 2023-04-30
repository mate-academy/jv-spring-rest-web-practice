package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private java.lang.Long id;
    private List<Ticket> tickets;
    private User userId;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }
}
