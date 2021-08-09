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
public class FlightTableModel extends AbstractTableModel{
    private List<Flight> flights; // for storing items
    private String[] titles = {"Number", "Origin", "Destination", "Date", "Price", "Child %"};

    public FlightTableModel(List<Flight> flights) {
        setFlights(flights);
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    @Override
    public int getRowCount() {
        return flights.size();
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
        Flight flight = flights.get(rowIndex);
        switch(columnIndex)
        {
            case 0: return flight.getFlightNo();
            case 1: return flight.getOrigin();
            case 2: return flight.getDestination();
            case 3: return flight.getDate();  
            case 4: return flight.getPrice();  
            case 5: return flight.getChildPerc();  
            default: return "";
        }
    } 
}
