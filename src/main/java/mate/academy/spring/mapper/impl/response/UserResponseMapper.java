package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper {
    public UserResponseDto toDto(User user) {
        UserResponseDto responseDto = new UserResponseDto();
        responseDto.setId(user.getId());
        responseDto.setEmail(user.getEmail());
        responseDto.setPassword(user.getPassword());
        return responseDto;
    }
}
