package com.gloflox;

import com.gloflox.model.BookingRequest;
import com.gloflox.model.Response;
import com.gloflox.model.StudioClass;
import com.gloflox.service.BookingService;
import com.gloflox.service.ClassService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class ServiceTests {

	private final ClassService classService = new ClassService();
	private final BookingService bookingService = new BookingService();

	@Test
	public void testCreateClassSuccess() {
		StudioClass studioClass = new StudioClass();
		studioClass.setName("Yoga");
		studioClass.setStartDate(LocalDate.of(2024, 1, 1));
		studioClass.setEndDate(LocalDate.of(2024, 1, 10));
		studioClass.setCapacity(20);

		Response response = classService.createClass(studioClass);
		assertTrue(response.isSuccess());
		assertEquals("Class created successfully", response.getMessage());
	}

	@Test
	public void testCreateClassInvalidInput() {
		StudioClass studioClass = new StudioClass();
		studioClass.setName(null);
		studioClass.setStartDate(LocalDate.of(2024, 1, 1));
		studioClass.setEndDate(LocalDate.of(2024, 1, 10));
		studioClass.setCapacity(20);

		Response response = classService.createClass(studioClass);
		assertFalse(response.isSuccess());
		assertEquals("Invalid input", response.getMessage());
	}

	@Test
	public void testBookClassSuccess() {
		BookingRequest request = new BookingRequest();
		request.setName("John Doe");
		request.setDate(LocalDate.of(2024, 1, 1));

		Response response = bookingService.bookClass(request);
		assertTrue(response.isSuccess());
		assertEquals("Booking successful", response.getMessage());
	}

	@Test
	public void testBookClassInvalidInput() {
		BookingRequest request = new BookingRequest();
		request.setName(null);
		request.setDate(LocalDate.of(2024, 1, 1));

		Response response = bookingService.bookClass(request);
		assertFalse(response.isSuccess());
		assertEquals("Invalid input", response.getMessage());
	}
}
