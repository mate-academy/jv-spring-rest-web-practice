package mate.academy.spring.model.dto.response;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartResponseDto {
    private Long userId;
    private List<Long> ticketIds;

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
