package mate.academy.spring.service.dto.mapping;

public interface DtoRequestMapper<D, C> {
    C parseFromDto(D dto);
}
