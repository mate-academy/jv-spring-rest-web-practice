package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private Long userId;
    private List<Long> ticketsIds;

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsId(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
