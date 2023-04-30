package mate.academy.spring.mapper.impl.request;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
