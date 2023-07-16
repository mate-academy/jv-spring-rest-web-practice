package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.Ticket;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTickets() {
        return ticketsId;
    }

    public void setTickets(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public Long getUser() {
        return userId;
    }

    public void setUser(Long userId) {
        this.userId = userId;
    }
}
