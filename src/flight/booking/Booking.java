/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.booking;

/**
 *
 * @author user
 */
public class Booking {
    
    private static int genNo = 1;
    private int bookingRef;
    private String customerName;
    private int numAdults;
    private int numChildren;
    private double totalPrice;
    private Flight flight;

    public Booking(String customerName, int numAdults, int numChildren) {
        setBookingRef(genNo++);
        setCustomerName(customerName);
        setNumAdults(numAdults);
        setNumChildren(numChildren);
        setTotalPrice(0);
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }
    
    public int getBookingRef() {
        return bookingRef;
    }

    public void setBookingRef(int bookingRef) {
        this.bookingRef = bookingRef;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getNumAdults() {
        return numAdults;
    }

    public void setNumAdults(int numAdults) {
        this.numAdults = numAdults;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public boolean equals(Object obj) {
        if (obj instanceof Booking)
            return getBookingRef() == (((Booking) obj).getBookingRef());
        return false;
    }
    
    public String toString() {
        return getCustomerName() + "\n" + getNumAdults() + "\n" + getNumChildren();
    }
    
}
