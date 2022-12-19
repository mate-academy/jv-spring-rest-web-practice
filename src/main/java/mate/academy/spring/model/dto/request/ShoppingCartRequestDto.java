package mate.academy.spring.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class ShoppingCartRequestDto {
    private List<Long> ticketIds;
    private Long userId;
}
