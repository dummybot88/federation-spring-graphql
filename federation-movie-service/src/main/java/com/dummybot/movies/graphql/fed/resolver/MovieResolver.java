package com.dummybot.movies.graphql.fed.resolver;

import com.dummybot.movies.graphql.fed.repository.Movie;
import com.dummybot.movies.graphql.fed.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MovieResolver {
  
  private final MovieService service;
  
  @QueryMapping
  public Iterable<Movie> fetchAllMovies(){
    return service.getAllMovies();
  }

}
