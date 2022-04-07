package mate.academy.spring.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private List<Long> ticketIds;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime orderDate;
    private Long userId;
}
