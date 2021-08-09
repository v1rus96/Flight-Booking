/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.booking;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class TravelAgent implements Serializable {

    private List<Booking> bookings;
    private List<Flight> flights;
    private String name;

    public TravelAgent(String name) {
            setName(name);
            setBookings(new ArrayList<Booking>());
            setFlights(new ArrayList<Flight>());
    }
    
    /**
	 * Adding user to CRS, could be a Staff or a 
	 * volunteer
	 * @param aUser New user to be added.
	 */
    public void addBooking(Booking booking) {
            getBookings().add(booking);
    }
    

    /**
     * Adding new trip organised by staff.
     * @param aTrip New trip to be added
     */
    public void addFlight(Flight flight) {
            getFlights().add(flight);
    }

    /**
     * Finding a user based on the unique username.
     * @param username username of user
     * @return The user whose username matches the
     * parametric username, null otherwise
     */
    public Flight findFlight(int flightNo) {
        for (Flight flight: getFlights())
            if (flight.getFlightNo() == flightNo)
                return flight;
        return null;
    }

    /**
     * Find a trip based on the trip ID
     * @param tripID ID of trip to search
     * @return Trip which matches parametric ID,
     * null otherwise
     */
    public Booking findBooking(int bookingRef) {
        for (Booking booking: getBookings())
            if (booking.getBookingRef()== bookingRef)
                return booking;
        return null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    
    public boolean removeBooking(int bookingRef) {
        Booking book = findBooking(bookingRef);
        EconomyFlight flight = null;
        if(book.getFlight() instanceof EconomyFlight)
            flight = (EconomyFlight) book.getFlight();
            if(flight.isFlexible()) {
                getBookings().remove(book);
                return true;
            }
        return false;        
    }
    
}
