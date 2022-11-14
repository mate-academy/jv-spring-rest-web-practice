package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> ticketId;

    public List<Long> getTicketId() {
        return ticketId;
    }

    public void setTicketId(List<Long> ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "ShoppingCartRequestDto{"
                + "ticketId=" + ticketId
                + '}';
    }
}
