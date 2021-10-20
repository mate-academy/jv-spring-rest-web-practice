package mate.academy.spring.model.dto.request;

import java.util.List;
import mate.academy.spring.model.Ticket;

public class ShoppingCartRequestDto {
    private List<Ticket> tickets;
    private Long userId;

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
