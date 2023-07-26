package com.dummybot.movies.graphql.fed.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {

  @Id
  private Long id;
  
  private String name;
  
  private int releaseYear;

}
