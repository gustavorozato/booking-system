package com.example.bookingsystem.controller;

import com.example.bookingsystem.dto.BookingDto;
import com.example.bookingsystem.dto.MovieDto;
import com.example.bookingsystem.model.Booking;
import com.example.bookingsystem.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    @RequestMapping("bookings")
    public MovieDto bookMovie(@RequestBody BookingDto bookingDto) {
        return bookingService.bookMovie(bookingDto).toDto();
    }

    @GetMapping
    @RequestMapping("movie/{id}/bookings")
    public List<BookingDto> getBookings(@PathVariable String id) {
        return bookingService.getBookings(id)
                .stream()
                .map(Booking::toDto)
                .toList();
    }
}
