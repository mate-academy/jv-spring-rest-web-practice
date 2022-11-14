package mate.academy.spring.mapper.impl.request;

import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartRequestMapperImpl<D, C> implements DtoRequestMapper<D, C> {
    private final UserService

    @Override
    public C fromDto(D dto) {

        return null;
    }
}
