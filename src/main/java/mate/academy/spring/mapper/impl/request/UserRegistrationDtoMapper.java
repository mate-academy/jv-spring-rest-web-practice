package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRegistrationDto;
import org.springframework.stereotype.Component;

@Component
public class UserRegistrationDtoMapper {
    public User toModel(UserRegistrationDto registrationDto) {
        User user = new User();
        user.setEmail(registrationDto.getEmail());
        user.setPassword(registrationDto.getPassword());
        return user;
    }
}
