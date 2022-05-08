package mate.academy.spring.model.dto.request;

import java.util.List;

public class ShoppingCartRequestDto {
    private List<Long> tickedId;
    private Long userId;

    public List<Long> getTickedId() {
        return tickedId;
    }

    public void setTickedId(List<Long> tickedId) {
        this.tickedId = tickedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
