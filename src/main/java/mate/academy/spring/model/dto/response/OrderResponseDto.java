package mate.academy.spring.model.dto.response;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private String orderDate;
    private Long userId;

    public void setId(Long id) {
        this.id = id;
    }

    public void setTicketsId(List<Long> ticketsId) {
        this.ticketsId = ticketsId;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
