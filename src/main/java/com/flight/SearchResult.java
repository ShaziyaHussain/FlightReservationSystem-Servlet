package com.flight;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Flight;
import core.FlightService;

/**
 * Servlet implementation class SearchResult
 */
@WebServlet("/SearchResult")
public class SearchResult extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String source = request.getParameter("source");
        String destination = request.getParameter("destination");
        String departureDate = request.getParameter("departureDate");

        List<Flight> availableFlights = FlightService.searchFlights(source, destination, departureDate);

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");
        out.println("<h2>Available Flights</h2>");
        
        for(Flight flight : availableFlights) {
            out.println("<p>");
            out.println("Flight: " + flight.getFlightNumber() + " - " + flight.getSource() + " to " + flight.getDestination());
            out.println(" <a href='DisplayFlightDetails?flightId=" + flight.getFlightId() + "'>Select</a>");
            out.println("</p>");
        }
        
        out.println("</body></html>");
    }
}
