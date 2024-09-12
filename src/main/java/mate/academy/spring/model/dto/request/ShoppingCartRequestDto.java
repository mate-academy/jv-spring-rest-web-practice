package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> ticketsId;

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
