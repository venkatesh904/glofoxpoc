package com.gloflox.service;

import com.gloflox.model.Booking;
import com.gloflox.model.BookingRequest;
import com.gloflox.model.Response;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class BookingService {

    private final Map<LocalDate, List<Booking>> bookings = new ConcurrentHashMap<>();

    public Response bookClass(BookingRequest request) {
        if (request.getName() == null || request.getDate() == null) {
            return new Response("Invalid input", false);
        }

        bookings.computeIfAbsent(request.getDate(), k -> new ArrayList<>())
                .add(new Booking(request.getName(), request.getDate()));
        return new Response("Booking successful", true);
    }

    public Map<LocalDate, List<Booking>> getBookings() {
        return bookings;
    }
}