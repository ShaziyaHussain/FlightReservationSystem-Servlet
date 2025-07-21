package core;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlightService {
	
	private static PreparedStatement pst1;


    public static List<Flight> searchFlights(String source, String destination, String departureDate) {
        // For demo: returning static flights
    	
    	
        List<Flight> flights = new ArrayList<>();
        
        try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next()) {
        
        flights.add(new Flight(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5),
				rst.getDate(6), rst.getTime(7), rst.getTime(8), rst.getInt(9), rst.getDouble(10))
);
        flights.add(new Flight(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5),
				rst.getDate(6), rst.getTime(7), rst.getTime(8), rst.getInt(9), rst.getDouble(10))
);
			}
        
    
        } catch (Exception e) {
			// TODO: handle exception
		}
        return flights;
    }
        
        public static Flight getFlightDetails(String flightId) throws SQLException {
            try (ResultSet rst = pst1.executeQuery()) {
                while (rst.next()) {
                    return new Flight(
                        rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
                        rst.getDate(5), rst.getDate(6), rst.getTime(7), rst.getTime(8),
                        rst.getInt(9), rst.getDouble(10)
                    );
                }
            }
            return null; // <-- important if no flight is found
        }

    }

