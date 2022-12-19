package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    @NotNull
    private List<Long> ticketIds;
    @NotNull
    @NotEmpty
    private LocalDateTime orderDate;
    @NotEmpty
    private Long userId;
}
