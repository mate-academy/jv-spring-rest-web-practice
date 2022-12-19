package mate.academy.spring.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketIds;
    private Long userId;
}
