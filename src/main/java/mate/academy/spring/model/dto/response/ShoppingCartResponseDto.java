package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;
import lombok.ToString;

@Data
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsIds;
}
