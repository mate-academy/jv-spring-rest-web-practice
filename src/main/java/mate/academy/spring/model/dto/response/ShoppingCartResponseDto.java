package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private java.lang.Long id;
    private List<Long> ticketsIds;

    public java.lang.Long getId() {
        return id;
    }

    public void setId(java.lang.Long id) {
        this.id = id;
    }

    public List<Long> getTicketsIds() {
        return ticketsIds;
    }

    public void setTicketsIds(List<Long> ticketsIds) {
        this.ticketsIds = ticketsIds;
    }
}
