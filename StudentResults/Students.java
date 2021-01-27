/**
 * Write a description of class Students here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

import java.util.*;

import java.lang.Object;

public class Students 
{
    private ArrayList<String> modules;
    
    private ArrayList<String> Details;
   
    static Scanner key = new Scanner(System.in);
    
    private int Age;
    
    private int Telephone;

    private String Name;

    private String Location;

    public Students(String N, int A, String L, int T)
    {
        Name = N;
        
        Age = A;
    
        Location = L;
        
        Telephone = T;
    }
    
    public int GetAge()
    {
        return Age;
    }
    
    public String Name()
    {
        return Name;
    }
    
    public String Location()
    {
        return Location;
    }
    
    public void StudentResults()
    {
        String M;
        
        String D;
        
        modules = new ArrayList<String>();
        
        Details = new ArrayList<String>();
        
        int G;
        
        int G2;
        
        int G3;
        
        int G4;
                        
        System.out.println("Thank you for your patience.");
        
        System.out.println();
        
        System.out.println("In order to continue your course in University, you need to input your modules and their results.");
        
        System.out.println();
        
        System.out.println("Let's start with inputting your Modules.");
        
        System.out.println();
        
        for(int i = 1; i <= 4; i++)
        {
            System.out.println("Module " + i + ": ");
            
            M = key.next();
            
            modules.add(M);
            
            System.out.println();
            
            System.out.println("Code for Module " + i + ": ");
            
            D = key.next();
            
            Details.add(D);
            
            System.out.println();
        }
        
        System.out.println();
        
        System.out.println("Good. Now input their results");
        
        System.out.println();
        
        System.out.println("Average grade of your first module: ");
        
        G = key.nextInt();
        
        System.out.println();
        
        System.out.println("Average grade of your second module: ");
        
        G2 = key.nextInt();
        
        System.out.println();
        
        System.out.println("Average grade of your third module: ");
        
        G3 = key.nextInt();
        
        System.out.println();
        
        System.out.println("Average grade for your fourth module: ");
        
        G4 = key.nextInt();
        
        System.out.println();
        
        System.out.println("Let's see....");
        
        System.out.println();
        
        for(int i = 0; i < modules.size(); i++)
        {
            Modules M6 = new Modules(modules.get(i)); 
            
            MD det = new MD(Details.get(i)); 
            
            System.out.println(M6);
            
            System.out.println();
            
            System.out.println(det);
            
            System.out.println();
        }
                        
        if(G >= 0 && G <= 39)
        {
            System.out.println("You have been awarded a F for your first module.");
                
            System.out.println();
        }
        else if(G > 39  && G <= 49)
        {
            System.out.println("You have been awarded a D for your first module.");
                
            System.out.println();
        }
        else if(G > 49 && G <= 59)
        {
            System.out.println("You have been awarded a C for your first module.");
                
            System.out.println();
        }
        else if(G > 59 && G <= 69)
        {
            System.out.println("You have been awarded a B for your first module.");
                
            System.out.println();
        }
        else if(G > 69 && G <= 79)
        {
            System.out.println("You have been awarded an A for your first module.");
                
            System.out.println();
        }
        else if(G > 79)
        {
            System.out.println("You have been awarded an A* for your module.");
                
            System.out.println();
        }
            
        if(G2 >= 0 && G2 <= 39)
        {
            System.out.println("You have been awarded a F for your second module.");
                
            System.out.println();
        }
        else if(G2 > 39  && G2 <= 49)
        {
            System.out.println("You have been awarded a D for your second module.");
                
            System.out.println();
        }
        else if(G2 > 49 && G2 <= 59)
        {
            System.out.println("You have been awarded a C for your second module.");
                
            System.out.println();
        }
        else if(G2 > 59 && G2 <= 69)
        {
            System.out.println("You have been awarded a B for your second module.");
                
            System.out.println();
                
            int credits2 = 15;
        }
        else if(G2 > 69 && G2 <= 79)
        {
            System.out.println("You have been awarded an A for your second module.");
                
            System.out.println();
        }
        else if(G2 > 79)
        {
            System.out.println("You have been awarded an A* for your second module.");
                
            System.out.println();
        }
        
        
        if(G3 >= 0 && G3 <= 39)
        {
            System.out.println("You have been awarded a F for your third module.");
                
            System.out.println();
        }
        else if(G3 > 39  && G3 <= 49)
        {
            System.out.println("You have been awarded a D for your third module.");
                
            System.out.println();
        }
        else if(G > 49 && G <= 59)
        {
            System.out.println("You have been awarded a C for your third module.");
                
            System.out.println();
        }
        else if(G3 > 59 && G3 <= 69)
        {
            System.out.println("You have been awarded a B for your third module.");
                
            System.out.println();
        }
        else if(G3 > 69 && G3 <= 79)
        {
            System.out.println("You have been awarded an A for your third module.");
                
            System.out.println();
        }
        else if(G3 > 79)
        {
            System.out.println("You have been awarded an A* for your third module.");
                
            System.out.println();
        }
        
        if(G4 >= 0 && G4 <= 39)
        {
            System.out.println("You have been awarded a F for your fourth module.");
                
            System.out.println();
        }
        else if(G3 > 39  && G3 <= 49)
        {
            System.out.println("You have been awarded a D for your fourth module.");
                
            System.out.println();
        }
        else if(G > 49 && G <= 59)
        {
            System.out.println("You have been awarded a C for your fourth module.");
                
            System.out.println();
        }
        else if(G3 > 59 && G3 <= 69)
        {
            System.out.println("You have been awarded a B for your fourth module.");
                
            System.out.println();
        }
        else if(G3 > 69 && G3 <= 79)
        {
            System.out.println("You have been awarded an A for your fourth module.");
                
            System.out.println();
        }
        else if(G3 > 79)
        {
            System.out.println("You have been awarded an A* for your fourth module.");
                
            System.out.println();
        }
        
        int TG = G + G2 + G3 + G4;
            
        System.out.println("Your total grade for all modules is" + " " + TG + ".");
            
        System.out.println();
        
        if(TG <= 200)
        {
            System.out.println("Unfortunately you won't be able to continue further your course.");
            
            System.out.println();
        }
        else if(TG > 200)
        {
            System.out.println("Congratulations!");
            
            System.out.println();
            
            System.out.println("You will be able to continue your course.");
            
            System.out.println();
        }
    }
}
