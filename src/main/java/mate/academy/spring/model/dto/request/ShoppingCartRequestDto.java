package mate.academy.spring.model.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequestDto {
    private List<Long> ticketIds;
    private Long userId;
}
