package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<List> ticketsId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<List> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<List> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
