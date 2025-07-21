package dao;

import static utils.DBUtils.*;
import static utils.DBUtils.closeConnection;
import static utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import core.Flight;

public class FlightDaoImpl implements FlightDao {

	private Connection connection;

	private PreparedStatement pst1;

	public FlightDaoImpl() throws SQLException {

		connection = openConnection();
		pst1 = connection
				.prepareStatement("select* from flights where source=? and destination=? and departure_date=?");
	}

	@Override
	public List<Flight> getAllAvailableFlights(String src, String dest, Date departureDate) throws SQLException {
		List<Flight> flights = new ArrayList<>();
		pst1.setString(1, src);
		pst1.setString(2, dest);
		pst1.setDate(3, departureDate);

		try (ResultSet rst = pst1.executeQuery()) {
			while (rst.next())
				flights.add(
						new Flight(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getDate(5),
								rst.getDate(6), rst.getTime(7), rst.getTime(8), rst.getInt(9), rst.getDouble(10)));
		}

		return flights;
	}

	@Override
	public void cleanUp() throws SQLException {
		if (pst1 != null) {
			pst1.close();

			closeConnection();
			System.out.println("User dao cleaned up");
		}

	}

}
