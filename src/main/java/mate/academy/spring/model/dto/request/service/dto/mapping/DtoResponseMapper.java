package mate.academy.spring.model.dto.request.service.dto.mapping;

public interface DtoResponseMapper<D, C> {
    D toDto(C object);
}
