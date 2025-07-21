package core;

import java.sql.SQLException;

public class ReservationService {
    
	public static Reservation createReservation(String flightId, String firstName, String lastName, String email, String phone)throws SQLException {
        // Generate a random reservation ID
        String reservationId = "R" + (int)(Math.random() * 10000);
        Flight flight = FlightService.getFlightDetails(flightId);
        return new Reservation(reservationId, flight.getFlightNumber(), firstName, lastName, email, phone);
    }
}
