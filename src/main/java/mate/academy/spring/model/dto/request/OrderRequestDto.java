package mate.academy.spring.model.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderRequestDto {
    private List<Long> ticketIds;
    private LocalDateTime orderDate;
    private Long userId;
}
