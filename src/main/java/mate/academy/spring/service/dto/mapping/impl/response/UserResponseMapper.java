package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements DtoResponseMapper<UserResponseDto, User> {
    @Override
    public UserResponseDto toDto(User object) {
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.setEmail(object.getEmail());
        userResponseDto.setId(object.getId());
        return userResponseDto;
    }
}
