package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapper implements DtoResponseMapper<CinemaHallResponseDto,
                                                                   CinemaHall> {
    @Override
    public CinemaHallResponseDto toDto(CinemaHall cinemaHall) {
        return new CinemaHallResponseDto(
                cinemaHall.getId(),
                cinemaHall.getCapacity()
        );
    }
}
