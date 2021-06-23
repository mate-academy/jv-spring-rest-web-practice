package mate.academy.spring.model.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private List<Long> ticketIds;
    private String orderDate;
    private Long userId;
}
