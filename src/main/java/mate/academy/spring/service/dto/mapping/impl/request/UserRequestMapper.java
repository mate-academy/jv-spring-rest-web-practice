package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;

public class UserRequestMapper implements DtoRequestMapper<UserRequestDto, User> {
    @Override
    public User fromDto(UserRequestDto requestDto) {
        User user = new User();
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }
}
