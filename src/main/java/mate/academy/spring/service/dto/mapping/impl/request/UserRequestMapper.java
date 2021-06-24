package mate.academy.spring.service.dto.mapping.impl.request;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.request.UserRequestDto;
import mate.academy.spring.security.AuthenticationService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import org.springframework.stereotype.Component;

@Component
public class UserRequestMapper implements DtoRequestMapper<UserRequestDto, User> {
    private final AuthenticationService authenticationService;

    public UserRequestMapper(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @Override
    public User fromDto(UserRequestDto dto) {
        if (dto.getPassword().equals(dto.getRepeatPassword())) {
            return authenticationService.register(dto.getEmail(), dto.getPassword());
        }
        throw new RuntimeException("passwords do not match");
    }
}
