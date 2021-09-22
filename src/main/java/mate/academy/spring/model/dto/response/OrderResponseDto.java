package mate.academy.spring.model.dto.response;

public class OrderResponseDto extends AbstractResponseDto {
    private String orderDate;

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
