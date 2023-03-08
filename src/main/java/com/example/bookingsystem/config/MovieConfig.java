package com.example.bookingsystem.config;

import com.example.bookingsystem.dao.MovieDao;
import com.example.bookingsystem.model.Movie;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MovieConfig {
    @Bean
    CommandLineRunner commandLineRunner(MovieDao movieDao) {
        return args -> {
            Movie movie = new Movie(
                    "Movie Name"
            );

            movieDao.add(movie);
        };
    }
}
