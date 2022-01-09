package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ShoppingCartResponseDto {
    private Long id;
    private List<Long> ticketsId;
}
