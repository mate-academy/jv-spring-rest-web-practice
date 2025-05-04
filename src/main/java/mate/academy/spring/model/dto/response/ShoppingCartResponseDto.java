package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private Long userId;
    private List<Long> ticketIds;

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

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketId(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
