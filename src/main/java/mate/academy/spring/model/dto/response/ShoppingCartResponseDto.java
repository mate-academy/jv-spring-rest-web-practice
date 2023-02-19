package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long Id;
    private List<Long> ticketsId;

    public ShoppingCartResponseDto(Long userAndShoppingCartIds, List<Long> ticketsId) {
        this.Id = userAndShoppingCartIds;
        this.ticketsId = ticketsId;
    }

    public ShoppingCartResponseDto() {
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
