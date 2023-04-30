package mate.academy.spring.mapper.impl.response;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
