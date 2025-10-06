package com.linkedinlearning.frankpmoley3.services;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.linkedinlearning.frankpmoley3.business.ReservationService;
import com.linkedinlearning.frankpmoley3.business.RoomReservation;
import com.linkedinlearning.frankpmoley3.data.Guest;
import com.linkedinlearning.frankpmoley3.data.Room;
import com.linkedinlearning.frankpmoley3.utils.DateUtils;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api")
public class WebServicesController {
	private final DateUtils dateUtils;
	private final ReservationService reservationService;

	public WebServicesController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}

	@GetMapping("/reservations")
	public List<RoomReservation> getReservations(@RequestParam(value = "date", required = false) String dateStr) {
		Date date = this.dateUtils.createDateFromDateString(dateStr);

		return this.reservationService.getRoomReservationsForDate(date);
	}

	@GetMapping("/guests")
	public List<Guest> getGuests() {
		return this.reservationService.getHotelGuests();
	}

	@GetMapping("/rooms")
	public List<Room> getRooms() {
		return this.reservationService.getRooms();
	}

	@PostMapping("/guests")
	@ResponseStatus(HttpStatus.CREATED)
	public void addGuest(@RequestBody Guest guest) {
		this.reservationService.addGuest(guest);
	}
}
