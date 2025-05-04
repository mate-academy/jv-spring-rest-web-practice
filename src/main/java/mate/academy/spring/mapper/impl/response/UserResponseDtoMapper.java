package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserResponseDtoMapper implements DtoResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User user) {
        return new UserResponseDto()
                .setId(user.getId())
                .setEmail(user.getEmail());
    }
}
