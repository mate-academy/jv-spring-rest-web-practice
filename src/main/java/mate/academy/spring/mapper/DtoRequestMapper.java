package mate.academy.spring.mapper;

public interface DtoRequestMapper<D, M> {
    M dtoToModel(D dto);
}
