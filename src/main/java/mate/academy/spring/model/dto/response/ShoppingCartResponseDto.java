package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    private Long userId;
}
