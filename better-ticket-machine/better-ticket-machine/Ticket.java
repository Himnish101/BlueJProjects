/**
 * Write a description of class Ticket here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

import java.lang.Object;

public class Ticket
{
    private String Region;
    
    private String Date;
    
    public Ticket(String Location, String Time)
    {
        Region = Location; 
        
        Date = Time;
    }
    
    private String GetReg()
    {
        return Region;
    }
    
    private String GetDate()
    {
        return Date;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s # Location: %s\t\n # Booked date: %s",
                            getClass().getName()
                            , GetReg()
                            , GetDate());
    }
}
