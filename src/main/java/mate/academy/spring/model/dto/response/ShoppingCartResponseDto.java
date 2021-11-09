package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;

    public Long getId() {
        return id;
    }

    public ShoppingCartResponseDto setId(Long id) {
        this.id = id;
        return this;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public ShoppingCartResponseDto setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
        return this;
    }
}
