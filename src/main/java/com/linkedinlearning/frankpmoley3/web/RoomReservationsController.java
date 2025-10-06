package com.linkedinlearning.frankpmoley3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.linkedinlearning.frankpmoley3.business.ReservationService;
import com.linkedinlearning.frankpmoley3.business.RoomReservation;
import com.linkedinlearning.frankpmoley3.utils.DateUtils;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/reservations")
public class RoomReservationsController {
	private final DateUtils dateUtils;
	private final ReservationService reservationService;

	public RoomReservationsController(DateUtils dateUtils, ReservationService reservationService) {
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
	}

	@GetMapping
	public String getReservations(
		@RequestParam(value = "date", required = false) String dateStr,
		Model model
	) {
		Date date = this.dateUtils.createDateFromDateString(dateStr);

		List<RoomReservation> roomReservations = this.reservationService.getRoomReservationsForDate(date);

		model.addAttribute("roomReservations", roomReservations);

		return "roomReservations";
	}
}
