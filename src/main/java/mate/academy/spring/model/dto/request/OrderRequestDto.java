package mate.academy.spring.model.dto.request;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private List<Long> ticketsId;
    private LocalDateTime orderDate;
    private String userEmail;
}
