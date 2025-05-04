package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long userAndCartId;
    private List<Long> ticketsId;

    public Long getUserAndCartId() {
        return userAndCartId;
    }

    public void setUserAndCartId(Long userAndCartId) {
        this.userAndCartId = userAndCartId;
    }

    public List<Long> getTicketsId() {
        return ticketsId;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    @Override
    public String toString() {
        return "ShoppingCartResponseDto{"
                + "userAndCartId=" + userAndCartId
                + ", ticketsId=" + ticketsId
                + '}';
    }
}
