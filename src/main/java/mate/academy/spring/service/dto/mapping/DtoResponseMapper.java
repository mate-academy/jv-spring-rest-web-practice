package mate.academy.spring.service.dto.mapping;

public interface DtoResponseMapper<D, C> {
    D parseToDto(C object);
}
