package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {
    public UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getId(),
                user.getEmail());
    }
}
