package mate.academy.spring.model.dto.request;

import java.util.List;
import javax.validation.constraints.NotNull;

public class ShoppingCartRequestDto {
    private List<Long> ticketIds;
    @NotNull
    private Long userId;

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
