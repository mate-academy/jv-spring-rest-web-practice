package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private java.lang.Long id;
    private List<Ticket> ticketIds;
    private User user;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public List<Ticket> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Ticket> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
