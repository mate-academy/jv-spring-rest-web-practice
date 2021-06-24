package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{"
                + " id=" + id
                + ", ticketIds=" + ticketIds
                + '}';
    }
}
