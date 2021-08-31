package mate.academy.spring.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long userId;
    private List<Long> ticketsIds;
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime orderDate;
}
