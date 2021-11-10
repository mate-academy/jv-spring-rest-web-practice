package mate.academy.spring.model.dto.response;

import java.util.List;

public class OrderResponseDto {
    private List<Long> tickets;
    private String orderDate;
    private long userId;

    public List<Long> getTickets() {
        return tickets;
    }

    public void setTickets(List<Long> tickets) {
        this.tickets = tickets;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
