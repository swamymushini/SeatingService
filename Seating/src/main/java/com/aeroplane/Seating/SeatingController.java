package com.aeroplane.Seating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SeatingController {
	@Autowired
	private SeatingService seatingService;
	
//	@CrossOrigin(origins = "http://localhost:3000")
	@PostMapping("/getPassengerArrangement")
	public int[][] getPassengerArrangement(@RequestBody Aeroplane aero) {
		return seatingService.getPassengerArrangement(aero) ;
	}
}
