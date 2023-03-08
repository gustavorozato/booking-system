package com.example.bookingsystem.repository;

import com.example.bookingsystem.dao.BookingDao;
import com.example.bookingsystem.dao.MovieDao;
import com.example.bookingsystem.model.Booking;
import com.example.bookingsystem.model.Movie;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookingRepository {
    private BookingDao bookingDao;
    private MovieDao movieDao;

    public BookingRepository(BookingDao bookingDao, MovieDao movieDao) {
        this.bookingDao = bookingDao;
        this.movieDao = movieDao;
    }

    public Movie addBooking(String username, String movieName) {
        return movieDao.findByName(movieName).map(movie -> {
            Booking booking = new Booking(username, movie);
            bookingDao.add(booking);
            movie.addBooking(booking);
            movieDao.update(movie);
            return movie;
        }).orElseThrow(() -> new IllegalStateException("No movie with that name"));
    }

    public List<Booking> getBookings(String movieId) {
        return null;
//        Optional<Movie> movie = movieDao.find(movieId);
//        if (movie.isPresent()) {
//            return movie.get().getBookings();
//        } else {
//            throw new IllegalStateException("No movie with that name");
//        }
    }
}
