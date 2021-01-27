import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.*;
import java.lang.Object;

/**
 * Write a description of JavaFX class Ticket2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Ticket2 
{
    static Scanner key = new Scanner(System.in);

    /**
     * Create a machine that issues tickets of the given price.
     */

    /**
     * @Return The price of a ticket.
     */
    
    static double TotalPrice(double a, double n)
    {
        a = a * n;
        
        return a;
    }
    
    static double EmptyCredits(double a)
    {
        a = 0;
        
        return a;
    }
    
    public static void TicketMachine(String[] args)
    {    
        String L;
        
        String D;
        
        double balance;
        
        double price;
        
        double tickets;
        
        int total = 0;
        
        System.out.println("Welcome to bluej lines ticket machine.");
        
        System.out.println();
        
        System.out.println("Before we start, please insert some money: ");
        
        balance = key.nextDouble();
        
        while(balance < 0)
        {
            System.out.println("Invalid ERROR!");
            
            System.out.println();
            
            System.out.println("Please try again.");
            
            System.out.println();
            
            System.out.println("Please insert some money: ");
            
            balance = key.nextDouble();
        }
        
        System.out.println();
        
        System.out.println("Where do you want to travel?");
        
        System.out.println();
        
        L = key.next();
        
        if(L.equals("Ayelsbury"))
        {
            price = 2.00;
            
            System.out.println("Standard price for a train ticket to this destination is " + price + ".");
            
            System.out.println();
        }
        else if(L.equals("Amersham"))
        {
            price = 3.00;
            
            System.out.println("Standard price for a train ticket to this destination is " + price + ".");
            
            System.out.println();
        }
        else if(L.equals("High_Wycombe"))
        {
            price = 3.30;
            
            System.out.println("Standard price for a train ticket to this destination is " + price + ".");
            
            System.out.println();
        }
        else
        {
            System.out.println("Standard price for a train ticket to this destination is ");
            
            price = key.nextDouble();
            
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("When do you want to travel?");
        
        D = key.next();
        
        System.out.println();
        
        Ticket T = new Ticket(L, D);
        
        System.out.println("How many tickets do you want to buy?");
        
        tickets = key.nextDouble();
        
        double TP = TotalPrice(price, tickets);
        
        String a;
        
        if(balance >= price) 
        {
            // Simulate the printing of a ticket.
            System.out.println("Payment accepted.");
            System.out.println();
            System.out.println("##################");
            System.out.println("# The BlueJ Line");
            System.out.println(T);
            System.out.println("# Tickets: " + tickets);
            System.out.println("# Price: " + TP + " cents.");
            System.out.println("##################");/**
             * An example of a method - replace this comment with your own
             *
             * @param  y  a sample parameter for a method
             * @return    the sum of x and y
             */
            
            System.out.println();

            // Update the total collected with the price.
            total = total += price;
            // Reduce the balance by the prince.
            balance = balance -= price;
            
            System.out.println("Balance left: " + balance + " cents");
            
            System.out.println();
            
            System.out.println("Do you want to empty your balance? (yes/no)");
            
            a = key.next();
            
            if(a.equals("yes"))
            {
                System.out.println("You've emptied your balance.");
                
                System.out.println();
                
                Double E = EmptyCredits(balance);
                
                System.out.println("Balance: " + E + " cents");
                
                System.out.println();
            }
            else if(a.equals("no"))
            {
                System.out.println("Your current balance has not been changed.");
                
                System.out.println();
            }
        }
        else {
            System.out.println("Unfortunately you don't have enough balance to get a ticket.");
            
            System.out.println("You must insert at least: " +
                               (price - balance) + " more cents.");
            
            System.out.println();
        }
    }
}