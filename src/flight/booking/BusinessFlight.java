/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class BusinessFlight extends Flight {

    private double rate;
    private List<Booking> bookings;
    
    public BusinessFlight(String origin, String destination, LocalDate date, double price, int childPerc, double rate) {
        super(origin, destination, date, price, childPerc);
        setRate(rate);
        setBookings(new ArrayList<Booking>());
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    
    @Override
    public boolean addBooking(Booking booking) {
        getBookings().add(booking);
        return true;
    }
    
    public double totalPrice(int refID) {
        double adultBusiness = 0.0;
        double childBusiness = 0.0;
        for(Booking booking : getBookings()) {
            if(booking.getBookingRef() == refID) {
                adultBusiness = (booking.getNumAdults() * getPrice()) * getRate();
                childBusiness = ((booking.getNumChildren() * super.getChildPerc()) / 100) * getRate();
            }
        }
        return adultBusiness + childBusiness;
    }
    
    public String toString() {
        return super.getOrigin() + "\n" + super.getDestination() + "\n" + super.getDate();
    }
    
}
