package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Ticket> tickets;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", tickets="
                + tickets + ", user=" + user + '}';
    }
}
