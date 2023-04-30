package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;

public class ShoppingCartResponseDto {
    private java.lang.Long id;
    private List<Ticket> tickets;

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
}
