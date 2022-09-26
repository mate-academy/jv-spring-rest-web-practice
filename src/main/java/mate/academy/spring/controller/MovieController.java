package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;
import mate.academy.spring.mapper.DtoRequestMapper;
import mate.academy.spring.mapper.DtoResponseMapper;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.dto.request.MovieRequestDto;
import mate.academy.spring.model.dto.response.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final DtoRequestMapper<MovieRequestDto, Movie> movieDtoRequestMapper;
    private final DtoResponseMapper<MovieResponseDto, Movie> movieDtoResponseMapper;

    public MovieController(MovieService movieService,
                           DtoRequestMapper<MovieRequestDto, Movie> movieDtoRequestMapper,
                           DtoResponseMapper<MovieResponseDto, Movie> movieDtoResponseMapper) {
        this.movieService = movieService;
        this.movieDtoRequestMapper = movieDtoRequestMapper;
        this.movieDtoResponseMapper = movieDtoResponseMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieResponseDto addMovie(@RequestBody @Valid MovieRequestDto dto) {
        Movie movie = movieService.add(movieDtoRequestMapper.fromDto(dto));
        return movieDtoResponseMapper.toDto(movie);
    }

    @GetMapping
    public List<MovieResponseDto> getAllMovies() {
        return movieService.getAll().stream()
                .map(movieDtoResponseMapper::toDto)
                .collect(Collectors.toList());
    }
}
