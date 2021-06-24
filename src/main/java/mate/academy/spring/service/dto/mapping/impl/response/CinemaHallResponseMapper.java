package mate.academy.spring.service.dto.mapping.impl.response;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.dto.response.CinemaHallResponseDto;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.stereotype.Component;

@Component
public class CinemaHallResponseMapper implements DtoResponseMapper<CinemaHallResponseDto,
                                                                   CinemaHall> {
    @Override
    public CinemaHallResponseDto parseToDto(CinemaHall cinemaHall) {
        CinemaHallResponseDto cinemaHallResponseDto = new CinemaHallResponseDto();
        cinemaHallResponseDto.setId(cinemaHall.getId());
        cinemaHallResponseDto.setCapacity(cinemaHall.getCapacity());
        return cinemaHallResponseDto;
    }
}
