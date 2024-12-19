package com.gloflox.controller;

import com.gloflox.model.Booking;
import com.gloflox.model.BookingRequest;
import com.gloflox.model.Response;
import com.gloflox.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Response bookClass(@RequestBody BookingRequest request) {
        return bookingService.bookClass(request);
    }

    @GetMapping
    public Map<LocalDate, List<Booking>> getBookings() {
        return bookingService.getBookings();
    }
}