package mate.academy.spring.model.dto.request;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCardRequestDto {
    private List<Long> ticketsId;
    private String userEmail;
}
