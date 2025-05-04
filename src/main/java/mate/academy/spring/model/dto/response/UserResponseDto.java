package mate.academy.spring.model.dto.response;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class UserResponseDto {
    private Long id;
    private String email;
}
