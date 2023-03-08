package com.example.bookingsystem.service;

import com.example.bookingsystem.dto.BookingDto;
import com.example.bookingsystem.dto.MovieDto;
import com.example.bookingsystem.model.Booking;
import com.example.bookingsystem.model.Movie;
import com.example.bookingsystem.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Movie bookMovie(BookingDto bookingDto) {
        return bookingRepository.addBooking(bookingDto.username(), bookingDto.movieName());
    }

    public List<Booking> getBookings(String id) {
        return bookingRepository.getBookings(id);
    }
}
