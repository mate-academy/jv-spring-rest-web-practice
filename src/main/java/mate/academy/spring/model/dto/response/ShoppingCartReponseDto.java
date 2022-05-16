package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartReponseDto {
    private Long cartId;
    private List<Long> ticketIds;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public List<Long> getTicketIds() {
        return ticketIds;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }
}
