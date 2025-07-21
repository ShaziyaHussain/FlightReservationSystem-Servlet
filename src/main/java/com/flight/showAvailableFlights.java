package com.flight;

import static utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import core.Flight;
import dao.FlightDao;
import dao.FlightDaoImpl;

/**
 * Servlet implementation class showAvailableFlights
 */
@WebServlet("/showAvailableFlights")
public class showAvailableFlights extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FlightDao flightDao;

	public void init() throws ServletException {
		System.out.println("in init " + getClass());
		try {
			// open connection
			openConnection();
			// create dao instance
			flightDao = new FlightDaoImpl();
			System.out.println(getClass() + " inited !");

		} catch (Exception e) {
			System.out.println(e);
			// centralized exc handling in servlets
			// re throw the same exc to WC , by wrapping it in ServletException
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy " + getClass());
		// dao's clean up
		try {
			flightDao.cleanUp();
		} catch (Exception e) {
			System.out.println(e);
			// how to inform WC about the exc?
			throw new RuntimeException("err in destroy", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("in do-post" + getClass());
		response.setContentType("text/html");

		try (PrintWriter pw = response.getWriter()) {
			String source = request.getParameter("source");
			String destination = request.getParameter("destination");
			java.sql.Date date = Date.valueOf(request.getParameter("departure_date"));

			List<Flight> flight = flightDao.getAllAvailableFlights(source, destination, date);

			pw.print("<h1></h1>");

		} catch (Exception e) {
			// re throw exc to the caller - WC
			throw new ServletException("err in do-post", e);
		}
	}

}
