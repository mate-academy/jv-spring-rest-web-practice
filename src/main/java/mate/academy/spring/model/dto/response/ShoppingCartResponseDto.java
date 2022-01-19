package mate.academy.spring.model.dto.response;

import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ShoppingCartResponseDto {
    Long id;
    List<Long> ticketIds;
}
