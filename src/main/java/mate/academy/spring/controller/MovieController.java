package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.dto.mapping.DtoRequestMapper;
import mate.academy.spring.service.dto.mapping.DtoResponseMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DtoRequestMapper<MovieRequestDto, Movie> movieRequestDtoMapper;
    private final DtoResponseMapper<MovieResponseDto, Movie> movieResponseDtoMapper;

    public MovieController(MovieService movieService,
                           DtoRequestMapper<MovieRequestDto, Movie> movieRequestDtoMapper,
                           DtoResponseMapper<MovieResponseDto, Movie> movieResponseDtoMapper) {
        this.movieService = movieService;
        this.movieRequestDtoMapper = movieRequestDtoMapper;
        this.movieResponseDtoMapper = movieResponseDtoMapper;
    }

    @PostMapping
    public MovieResponseDto addMovie(@RequestBody MovieRequestDto dto) {
        Movie movie = movieService.add(movieRequestDtoMapper.fromDto(dto));
        return movieResponseDtoMapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieResponseDtoMapper::toDto)
                .collect(Collectors.toList());
    }
}
