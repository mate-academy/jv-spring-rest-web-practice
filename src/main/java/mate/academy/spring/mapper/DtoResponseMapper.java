package mate.academy.spring.mapper;

public interface DtoResponseMapper<D, M> {
    D modelToDto(M object);
}
