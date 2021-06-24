package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private List<Long> ticketsId;
    private Long userId;
}
