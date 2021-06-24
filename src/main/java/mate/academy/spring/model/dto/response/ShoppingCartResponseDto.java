package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
    private Long userId;
}
