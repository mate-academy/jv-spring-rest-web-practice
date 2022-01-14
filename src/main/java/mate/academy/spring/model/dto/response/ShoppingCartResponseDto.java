package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    private Long userId;

    public List<Long> getTicketsIds() {
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
