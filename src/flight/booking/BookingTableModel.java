/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package flight.booking;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author user
 */
public class BookingTableModel extends AbstractTableModel{
    private List<Booking> bookings; // for storing items
    private String[] titles = {"Ref", "Customer", "Adults", "Children", "Total Price"};

    public BookingTableModel(List<Booking> booking) {
        setBookings(booking);
    }

    public void setBookings(List<Booking> booking) {
        this.bookings = booking;
    }

    @Override
    public int getRowCount() {
        return bookings.size();
    }
    
    @Override
    public int getColumnCount() {
        return titles.length;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return titles[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Booking booking = bookings.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return booking.getBookingRef();
            case 1: return booking.getCustomerName();
            case 2: return booking.getNumAdults();
            case 3: return booking.getNumChildren();  
            case 4: return booking.getTotalPrice();  
            default: return "";
        }
    } 
}
