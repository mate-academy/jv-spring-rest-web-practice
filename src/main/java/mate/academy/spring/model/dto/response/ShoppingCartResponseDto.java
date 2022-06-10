package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Ticket> tickets;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
