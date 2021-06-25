package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Data;
import mate.academy.spring.model.User;

@Data
public class ShoppingCartResponseDto {
    private List<Long> ticketsId;
    private User user;
}
