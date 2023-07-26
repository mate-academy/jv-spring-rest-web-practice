package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTickets() {
        return ticketIds;
    }

    public void setTickets(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
