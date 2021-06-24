package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTickets() {
        return ticketsId;
    }

    public void setTickets(List<Long> tickets) {
        this.ticketsId = tickets;
    }
}
