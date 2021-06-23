package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }

    public Long getId() {
        return id;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }
}
