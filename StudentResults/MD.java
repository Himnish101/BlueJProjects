/**
 * Write a description of class MD here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */ 

import java.lang.Object;

import java.util.*;

public class MD
{
    private String D;
    
    public MD(String Details)
    {
        D = Details;
    }
    
    @Override
    
    public String toString()
    {
        return String.format("%s Details of Module: %s",
                            getClass().getName(),
                            D);
    }
}
