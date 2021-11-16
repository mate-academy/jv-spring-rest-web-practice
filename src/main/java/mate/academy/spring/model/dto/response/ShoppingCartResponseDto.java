package mate.academy.spring.model.dto.response;

import java.util.List;
import mate.academy.spring.model.User;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
