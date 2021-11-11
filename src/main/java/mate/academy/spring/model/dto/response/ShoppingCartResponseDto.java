package mate.academy.spring.model.dto.response;

import java.util.List;

public class ShoppingCartResponseDto {
    private List<Long> ticketIdList;
    private Long userId;

    public List<Long> getTicketIdList() {
        return ticketIdList;
    }

    public void setTicketIdList(List<Long> ticketIdList) {
        this.ticketIdList = ticketIdList;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
