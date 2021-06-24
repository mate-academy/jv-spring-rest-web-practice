package mate.academy.spring.model.dto.response;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private String orderDate;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketIds(List<Long> ticketIds) {
        this.ticketIds = ticketIds;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderResponseDto{"
                + " id=" + id
                + ", ticketIds=" + ticketIds
                + ", orderDate='" + orderDate + '\''
                + ", userId=" + userId
                + '}';
    }
}
