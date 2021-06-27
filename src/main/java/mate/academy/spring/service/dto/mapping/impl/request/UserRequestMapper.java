package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements DtoRequestMapper<UserRegistrationDto, User> {
    @Override
    public User fromDto(UserRegistrationDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
