package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.response.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionResponseMapper implements DtoResponseMapper<MovieSessionResponseDto,
                                                                     MovieSession> {
    @Override
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        return new MovieSessionResponseDto(
                movieSession.getId(),
                movieSession.getMovie().getTitle(),
                movieSession.getShowTime(),
                movieSession.getCinemaHall().getCapacity()
        );
    }
}
