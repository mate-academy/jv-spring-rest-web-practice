package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<Long> ticketIds;

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{"
                + "ticketIds=" + ticketIds
                + '}';
    }
}
