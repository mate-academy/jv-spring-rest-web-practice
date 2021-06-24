package mate.academy.spring.model.dto.request;

import lombok.Data;
import lombok.ToString;

@Data
public class UserRequestDto {
    private String email;
    @ToString.Exclude
    private String password;
}
