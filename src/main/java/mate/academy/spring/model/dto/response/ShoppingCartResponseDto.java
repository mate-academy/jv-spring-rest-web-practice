package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long shoppingCartId;
    private List<Long> tickets;
    private Long userId;
}
