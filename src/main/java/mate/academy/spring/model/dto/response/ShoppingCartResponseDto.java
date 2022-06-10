package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<Long> ticketIds;
    private Long userId;

    public List<Long> getTicketsIds() {
        return ticketIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketIds = ticketsIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
