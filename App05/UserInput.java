import java.util.*;

public class UserInput
{
    private String ProgramStart;
    
    static Scanner key = new Scanner(System.in);
    
    public UserInput(String P)
    {
        ProgramStart = P;
    }
    
    public String GetProgStart()
    {
        return ProgramStart;
    }
    
    public void SetProgStart(String P)
    {
        while(!ProgramStart.equals("Program.Main()"))
        {
            System.out.println("ERROR!");
            
            System.out.println();
            
            System.out.println("Please try again.");
            
            System.out.println();
            
            ProgramStart = key.next();
        }
        
        ProgramStart = P;
    }
    
    public String toString()
    {
        String title = "******************" + "\n\n Stock Management Application"
        + "\n\n App05: by Himnish Nanda \n\n" + "******************";
        
        return title;
    }
}
