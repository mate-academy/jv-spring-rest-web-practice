package mate.academy.spring.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class UserResponseDto {
    private Long id;
    private String email;
}
