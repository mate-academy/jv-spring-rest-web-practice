package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> ticketsIds;
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }
}
