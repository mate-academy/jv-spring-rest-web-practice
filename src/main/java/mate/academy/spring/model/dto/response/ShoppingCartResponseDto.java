package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartResponseDto {
    private Long userAndCartId;
    private List<Long> ticketsId;
}
