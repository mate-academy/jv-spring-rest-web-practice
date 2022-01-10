package mate.academy.spring.model.dto.request.service.dto.mapping.impl.response;

import mate.academy.spring.model.User;
import mate.academy.spring.model.dto.response.AuthenticationResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationResponseMapper implements
        DtoResponseMapper<AuthenticationResponseDto, User> {
    @Override
    public AuthenticationResponseDto toDto(User user) {
        AuthenticationResponseDto authenticationResponseDto = new AuthenticationResponseDto();
        authenticationResponseDto.setId(user.getId());
        authenticationResponseDto.setEmail(user.getEmail());
        return authenticationResponseDto;
    }
}
