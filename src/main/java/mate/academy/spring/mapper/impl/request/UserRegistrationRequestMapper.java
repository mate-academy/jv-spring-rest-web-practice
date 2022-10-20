package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationRequestMapper implements DtoRequestMapper<UserRegistrationDto, User> {
    @Override
    public User fromDto(UserRegistrationDto dto) {
        User user = new User();
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }
}
