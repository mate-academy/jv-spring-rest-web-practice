package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements DtoRequestMapper<User, UserRequestDto> {
    @Override
    public UserRequestDto fromDto(User user) {
        return null;
    }
}
