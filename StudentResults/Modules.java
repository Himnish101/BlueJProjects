/**
 * Write a description of class Modules here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.lang.Object;

import java.util.*;

public class Modules
{
    private String module;
    
    public Modules(String M1)
    {
        module = M1;
    }
    
    @Override
    public String toString()
    {
        return String.format("%s Module: %s",
                            getClass().getName(),
                            module);
    }
}
