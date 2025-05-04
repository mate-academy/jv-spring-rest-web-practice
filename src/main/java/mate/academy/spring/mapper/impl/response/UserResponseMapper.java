package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.UserDtoResponse;
import org.springframework.stereotype.Component;

@Component
public class UserResponseMapper implements DtoResponseMapper<UserDtoResponse, User> {
    @Override
    public UserDtoResponse toDto(User user) {
        UserDtoResponse userDtoResponse = new UserDtoResponse();
        userDtoResponse.setId(user.getId());
        userDtoResponse.setEmail(user.getEmail());
        return userDtoResponse;
    }
}
