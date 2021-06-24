package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private String orderDate;
    private Long userId;
}
