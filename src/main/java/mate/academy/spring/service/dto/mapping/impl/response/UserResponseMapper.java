package mate.academy.spring.service.dto.mapping.impl.response;


import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;

public class UserResponseMapper implements DtoResponseMapper<UserResponseDto, User> {

    @Override
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        return dto;
    }
}
