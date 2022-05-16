package mate.academy.spring.mapper;

public interface DtoRequestMapper<D, C> {
    C toEntity(D dto);
}
