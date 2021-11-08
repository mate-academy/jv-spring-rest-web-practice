package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public ShoppingCartResponseDto setUserId(Long userId) {
        this.userId = userId;
        return this;
    }
}
