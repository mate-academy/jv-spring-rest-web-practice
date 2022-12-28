package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> ticketsIds;
    private Long userId;

    public List<Long> getTicketsId() {
        return ticketsIds;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsIds = ticketsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
