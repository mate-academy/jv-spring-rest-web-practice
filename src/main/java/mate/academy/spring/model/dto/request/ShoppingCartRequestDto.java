package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> tickedIds;
    private Long userId;

    public List<Long> getTickedIds() {
        return tickedIds;
    }

    public void setTickedIds(List<Long> tickedId) {
        this.tickedIds = tickedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
