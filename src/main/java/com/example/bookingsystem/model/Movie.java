package com.example.bookingsystem.model;

import com.example.bookingsystem.dto.MovieDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class Movie {
    @Id
    @SequenceGenerator(
            name = "movie_sequence",
            sequenceName = "movie_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "movie_sequence"
    )
    private Long id;
    private String name;
    @OneToMany(fetch = FetchType.LAZY)
    private List<Booking> bookings;

    public Movie(String name) {
        this.name = name;
    }

    public void addBooking(Booking booking) {
        if (bookings == null) bookings = new ArrayList<>();
        bookings.add(booking);
    }

    public MovieDto toDto() {
        return new MovieDto(name);
    }
}
