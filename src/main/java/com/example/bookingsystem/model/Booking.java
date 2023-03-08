package com.example.bookingsystem.model;

import com.example.bookingsystem.dto.BookingDto;
import com.example.bookingsystem.dto.MovieDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Booking {
    @Id
    @SequenceGenerator(
            name = "booking_sequence",
            sequenceName = "booking_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "booking_sequence"
    )
    private Long id;
    private String username;
    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    public Booking(String username, Movie movie) {
        this.username = username;
        this.movie = movie;
    }

    public BookingDto toDto() {
        return new BookingDto(username, movie.getName());
    }
}
