package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long userAndShoppingCartIds;

    private List<Long> ticketsId;

    public ShoppingCartResponseDto(Long userAndShoppingCartIds, List<Long> ticketsId) {
        this.userAndShoppingCartIds = userAndShoppingCartIds;
        this.ticketsId = ticketsId;
    }

    public Long getUserAndShoppingCartIds() {
        return userAndShoppingCartIds;
    }

    public void setUserAndShoppingCartIds(Long userAndShoppingCartIds) {
        this.userAndShoppingCartIds = userAndShoppingCartIds;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }
}
