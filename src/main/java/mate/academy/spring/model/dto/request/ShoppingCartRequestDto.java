package mate.academy.spring.model.dto.request;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingCartRequestDto {
    @NotNull
    private List<Long> ticketIds;
    @NotEmpty
    private Long userId;
}
