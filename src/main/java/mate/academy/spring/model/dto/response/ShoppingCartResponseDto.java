package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketId;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketId() {
        return ticketId;
    }

    public void setTicketId(List<Long> ticketId) {
        this.ticketId = ticketId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" + "id=" + id + ", ticketId="
                + ticketId + ", user=" + user + '}';
    }
}
