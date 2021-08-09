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
public class EconomyFlight extends Flight {

    private boolean isFlexible;
    private List<Booking> bookings;
    
    public EconomyFlight(String origin, String destination, LocalDate date, double price, int childPerc, boolean isFlexible) {
        super(origin, destination, date, price, childPerc);
        setIsFlexible(isFlexible);
        setBookings(new ArrayList<Booking>());
    }
    
    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }
    
    public boolean isFlexible() {
        return isFlexible;
    }

    public void setIsFlexible(boolean isFlexible) {
        this.isFlexible = isFlexible;
    }
    
    @Override
    public boolean addBooking(Booking booking) {
        getBookings().add(booking);
        return true;
    }
    
    public double totalPrice(int refID) {
        double adultEconomy = 0.0;
        double childEconomy = 0.0;
        for(Booking booking : getBookings()) {
            if(booking.getBookingRef() == refID) {
                adultEconomy = booking.getNumAdults() * getPrice();
                childEconomy = (booking.getNumChildren() * super.getChildPerc()) / 100;
            }
        }
        return adultEconomy + childEconomy;
    }
    
    public String toString() {
        return super.getOrigin() + "\n" + super.getDestination() + "\n" + super.getDate();
    }
    
}
