package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "ShoppingCartDto{"
                + "id=" + id
                + ", ticketsId=" + ticketsId
                + ", userId=" + userId
                + '}';
    }
}
