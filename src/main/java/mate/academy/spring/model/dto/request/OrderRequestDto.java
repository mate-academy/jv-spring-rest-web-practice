package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;

public class OrderRequestDto {
    private LocalDateTime orderDate;

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
}
