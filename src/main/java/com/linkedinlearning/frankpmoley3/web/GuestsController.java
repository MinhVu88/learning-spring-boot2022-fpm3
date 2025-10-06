package com.linkedinlearning.frankpmoley3.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.linkedinlearning.frankpmoley3.business.ReservationService;

@Controller
@RequestMapping("/guests")
public class GuestsController {
	private final ReservationService reservationService;

	public GuestsController(ReservationService reservationService) {
		this.reservationService = reservationService;
	}

	@GetMapping
	public String getGuests(Model model) {
		model.addAttribute("guests", this.reservationService.getHotelGuests());

		return "hotelGuests";
	}
}
