package com.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Reservation;
import core.ReservationService;

/**
 * Servlet implementation class CreateReservation
 */
@WebServlet("/CreateReservation")
public class CreateReservation extends HttpServlet {
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightId = request.getParameter("flightId");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");

        try {
        Reservation reservation = ReservationService.createReservation(flightId, firstName, lastName, email, phone);
        
        // Optional: Invalidate session
        request.getSession().invalidate();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        out.println("<html><body>");
        out.println("<h2>Reservation Successful!</h2>");
        out.println("<p>Reservation ID: " + reservation.getReservationId() + "</p>");
        out.println("<p>Passenger Name: " + reservation.getFirstName() + " " + reservation.getLastName() + "</p>");
        out.println("<p>Flight Number: " + reservation.getFlightNumber() + "</p>");
        out.println("<p>Please save your Reservation ID for future reference.</p>");
        out.println("</body></html>");
        
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, set error message and forward to error.jsp
        }
    }
}

