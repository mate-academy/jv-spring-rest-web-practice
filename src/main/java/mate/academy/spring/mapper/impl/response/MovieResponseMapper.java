package mate.academy.spring.mapper.impl.response;

import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieResponseMapper implements DtoResponseMapper<MovieResponseDto, Movie> {
    @Override
    public MovieResponseDto toDto(Movie movie) {
        return new MovieResponseDto(
                movie.getId(),
                movie.getTitle(),
                movie.getDescription()
        );
    }
}
