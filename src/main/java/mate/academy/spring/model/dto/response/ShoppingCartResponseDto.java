package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
