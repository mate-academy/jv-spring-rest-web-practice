package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto userResponseDto =
                new UserResponseDto();
        userResponseDto.setId(user.getId());
        userResponseDto.setEmail(user.getEmail());
        userResponseDto.setPassword(user.getPassword());
        return userResponseDto;
    }
}
