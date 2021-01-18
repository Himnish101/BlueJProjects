/**
 * Write a description of class Activities here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

public class Activities
{
    static Scanner key = new Scanner(System.in);
    
    public void GettingFood()
    {
        String Option;
        
        System.out.println("Option 1 - mac + cheese \n");
        
        System.out.println("Option 2 - pizza \n");
        
        System.out.println("Option 3 - zinger box meal \n");
        
        System.out.println("Option 4 - chicken wings \n");
        
        Option = key.next();
        
        System.out.println();
        
        if(Option.equals("mac-cheese"))
        {
            System.out.println("You paid for the " +  Option + ". \n");
        }
        else if(Option.equals("pizza"))
        {
            System.out.println("You paid for the " +  Option + ". \n");
        }
        else if(Option.equals("zinger-box-meal"))
        {
            System.out.println("You paid for the " +  Option + ". \n");
        }
        else if(Option.equals("chicken-wings"))
        {
            System.out.println("You paid for the " +  Option + ". \n");
        }
    }
    
    public void ReadBook()
    {
        System.out.println("You've read a book in the library. \n");
        
        System.out.println("The book was about the history of the gaming industry. \n");
    }
    
    public void Sprint()
    {
        System.out.println("You took a sprint in the gymnasium. \n");
    }
    
    public void Badminton()
    {
        System.out.println("You managed to find some racquets and played an intense game of badminton. \n");
    }
    
    public void P3D()
    {
        System.out.println("You used the key from the office to 3D print your project. \n");
    }
    
    public void LabA()
    {
        System.out.println("You presented your project to everyone. \n");
        
        System.out.println("It seems everyone's pleased. \n");
    }
    
    public void Theater()
    {
        System.out.println("You've successfully used the prop and performed a good act. \n");
    }
}
