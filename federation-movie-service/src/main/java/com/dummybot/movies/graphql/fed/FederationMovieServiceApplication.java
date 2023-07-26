package com.dummybot.movies.graphql.fed;

import com.dummybot.movies.graphql.fed.repository.Movie;
import com.dummybot.movies.graphql.fed.repository.MovieRepository;
import graphql.schema.idl.SchemaDirectiveWiring;
import java.time.LocalDate;
import java.util.List;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.graphql.GraphQlSourceBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class FederationMovieServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(FederationMovieServiceApplication.class, args);
	}

	@Bean
	ApplicationRunner applicationRunner(MovieRepository movieRepository){
		return args -> {
			movieRepository.saveAll(
					List.of(new Movie(11L, "Wolf of Wall Street", 2014),new Movie(12L, "Oppenheimer", 2023))
					);
		};
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(final CorsRegistry registry) {
				registry.addMapping("/graphql/**")
						.allowedOrigins(CorsConfiguration.ALL)
						.allowedHeaders(CorsConfiguration.ALL)
						.allowedMethods(CorsConfiguration.ALL);
			}
		};
	}

}
