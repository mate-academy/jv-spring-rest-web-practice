package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<Long> ticketIds;
    private Long cartAndUserId;

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public Long getCartAndUserId() {
        return cartAndUserId;
    }

    public void setCartAndUserId(Long cartAndUserId) {
        this.cartAndUserId = cartAndUserId;
    }
}
