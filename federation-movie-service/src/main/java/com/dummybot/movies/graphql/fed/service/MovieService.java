package com.dummybot.movies.graphql.fed.service;

import com.dummybot.movies.graphql.fed.repository.Movie;
import com.dummybot.movies.graphql.fed.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MovieService {

  private final MovieRepository movieRepository;

  public Iterable<Movie> getAllMovies(){
    return movieRepository.findAll();
  }

}
