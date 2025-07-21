package core;

public class Reservation {
    private String reservationId;
    private String flightNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
	
    
    public Reservation(String reservationId, String flightNumber, String firstName, String lastName, String email,
			String phone) {
		super();
		this.reservationId = reservationId;
		this.flightNumber = flightNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}


	@Override
	public String toString() {
		return "Reservation [reservationId=" + reservationId + ", flightNumber=" + flightNumber + ", firstName="
				+ firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + "]";
	}


	public String getReservationId() {
		return reservationId;
	}


	public void setReservationId(String reservationId) {
		this.reservationId = reservationId;
	}


	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}

    
    
	
    
    
}

