package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCardResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;
}
