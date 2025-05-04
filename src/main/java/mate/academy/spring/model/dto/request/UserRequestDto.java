package mate.academy.spring.model.dto.request;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Accessors(chain = true)
@Setter
public class UserRequestDto {
    private String email;
    private String password;
}
