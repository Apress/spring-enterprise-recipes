package com.apress.springenterpriserecipes.springintegration.myholiday;

import java.util.List;

import org.springframework.integration.annotation.Gateway;

public interface VacationService {

	@Gateway(requestChannel = "requests", replyChannel = "responses")
	List<HotelReservation> findHotels(HotelReservationSearch hotelReservationSearch);

}
