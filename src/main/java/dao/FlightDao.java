package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import core.Flight;


public interface FlightDao {

	List<Flight> getAllAvailableFlights(String src, String dest, Date departureDate) throws SQLException;
	
	void cleanUp() throws SQLException;
}
