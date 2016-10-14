package com.apress.springenterpriserecipes.springintegration.myholiday;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;

public class VacationServiceImpl implements VacationService, InitializingBean {

	private List<HotelReservation> hotelReservations;

	public void afterPropertiesSet() throws Exception {
		hotelReservations = Arrays.asList(new HotelReservation("Bilton", 243.200F), new HotelReservation("East Western", 75.0F),
				new HotelReservation("Thairfield Inn", 70F), new HotelReservation("Park In The Inn", 200.00F));
	}

	public List<HotelReservation> findHotels(HotelReservationSearch searchMsg) {
		try {
			Thread.sleep(1000);
		} catch (Throwable th) {
		}
		return this.hotelReservations;
	}

}
