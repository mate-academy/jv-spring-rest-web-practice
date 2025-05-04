package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public List<Long> getTickets() {
        return ticketsIds;
    }

    public void setTickets(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }
}
