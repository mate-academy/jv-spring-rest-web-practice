package mate.academy.spring.model.dto.response;

import java.util.List;

public class OrderResponseDto {
    private Long id;
    private List<Long> tiketIds;
    private String orderDate;
    private Long userId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Long> getTiketIds() {
        return tiketIds;
    }

    public void setTiketIds(List<Long> tiketIds) {
        this.tiketIds = tiketIds;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
