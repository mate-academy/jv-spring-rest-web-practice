package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements DtoRequestMapper<UserResponseDto, User> {
    @Override
    public User fromDto(UserResponseDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
