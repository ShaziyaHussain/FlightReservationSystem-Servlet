package core;

import java.sql.Date;
import java.sql.Time;

/* Airline, Source, Destination, departure_date, arrival_date, departure_time,
 *  arrival_time, no_of_stops, price*/
public class Flight {

	private String flightNumber;
	private int flightId;
	private String airline;
	private String source;
	private String destination;
	private Date departureDate;
	private Date arrivalDate;
	private Time arrivalTime;
	private Time departureTime;
	private int noOfStops;
	private double price;


	public Flight(int flightId, String airline, String source, String destination, Date departureDate, Date arrivalDate,
			Time arrivalTime, Time departureTime, int noOfStops, double price) {
		super();
		this.flightId = flightId;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.noOfStops = noOfStops;
		this.price = price;
	}


	@Override
	public String toString() {
		return "Flight [airline=" + airline + ", source=" + source + ", destination=" + destination + ", departureDate="
				+ departureDate + ", arrivalDate=" + arrivalDate + ", arrivalTime=" + arrivalTime + ", departureTime="
				+ departureTime + ", noOfStops=" + noOfStops + ", price=" + price + "]";
	}


	public String getAirline() {
		return airline;
	}


	public void setAirline(String airline) {
		this.airline = airline;
	}


	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}


	public String getDestination() {
		return destination;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}


	public Date getDepartureDate() {
		return departureDate;
	}


	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}


	public Date getArrivalDate() {
		return arrivalDate;
	}


	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}


	public Time getArrivalTime() {
		return arrivalTime;
	}


	public void setArrivalTime(Time arrivalTime) {
		this.arrivalTime = arrivalTime;
	}


	public Time getDepartureTime() {
		return departureTime;
	}


	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
	}


	public int getNoOfStops() {
		return noOfStops;
	}


	public void setNoOfStops(int noOfStops) {
		this.noOfStops = noOfStops;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getFlightNumber() {
        return flightNumber;
    }


	public int getFlightId() {
		return flightId;
	}
	
	
	
	
	
	
	
	
}
