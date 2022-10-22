package mate.academy.spring.model.dto.request;

import java.util.List;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
