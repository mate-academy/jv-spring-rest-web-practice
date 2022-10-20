package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private List<Long> ticketsId;
    private Long userId;
}
