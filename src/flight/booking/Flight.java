/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.booking;

import java.time.LocalDate;

/**
 *
 * @author user
 */
public abstract class Flight implements Comparable<Flight>{

    private static int genNo = 1;
    private int flightNo;
    private String origin;
    private String destination;
    private LocalDate date;
    private double price;
    private int childPerc;
    
    public Flight(String origin, String destination, LocalDate date, double price, int childPerc) {
        setFlightNo(genNo++);
        setOrigin(origin);
        setDestination(destination);
        setDate(date);
        setPrice(price);
        setChildPerc(childPerc);
    }
    
    public int getFlightNo() {
        return flightNo;
    }

    public void setFlightNo(int flightNo) {
        this.flightNo = flightNo;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getChildPerc() {
        return childPerc;
    }

    public void setChildPerc(int childPerc) {
        this.childPerc = childPerc;
    }
    
    abstract boolean addBooking(Booking booking);
    abstract double totalPrice(int RefID);
    
    public boolean equals(Object obj) {
        if (obj instanceof Flight)
            return getFlightNo() == (((Flight) obj).getFlightNo());
        return false;
    }
    
    public int compareTo(Flight flight) {
        return getOrigin().compareTo(flight.getOrigin());
    }
}
