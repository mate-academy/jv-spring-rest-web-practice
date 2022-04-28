package mate.academy.spring.mapper;

public interface DtoRequestMapper<D, C> {
    C toDto(D dto);
}
