package mate.academy.spring.model.dto.request.service.dto.mapping;

public interface DtoRequestMapper<D, C> {
    C fromDto(D dto);
}
