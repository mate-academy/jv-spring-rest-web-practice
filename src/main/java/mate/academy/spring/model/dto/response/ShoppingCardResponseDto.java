package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCardResponseDto {
    private Long id;
    private List<Long> ticketsId;
    private String userEmail;

}
