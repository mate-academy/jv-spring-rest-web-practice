package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserDtoResponseMapper implements DtoResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User object) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setId(object.getId());
        userResponseDto.setEmail(object.getEmail());
        return userResponseDto;
    }
}
