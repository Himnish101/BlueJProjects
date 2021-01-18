import java.util.*;

public class MainApp 
{   
    static Scanner key = new Scanner(System.in);
    
    private StockManagement manager;
    
    public MainApp(StockManagement manager)
    {
        this.manager = manager;
    }
    
    public void Main()
    {    
        String Title;
        
        int Option;
        
        Title = key.next();
        
        UserInput UI = new UserInput(Title);
        
        UI.SetProgStart(Title);
        
        System.out.println(UI.toString());
        
        System.out.println();
        
        System.out.println("Thank you for downloading this app.");
        
        System.out.println();
        
        System.out.println("We are here to help manage your stock in the best way possible.");
        
        System.out.println();
        
        System.out.println("How may we help you?");
        
        System.out.println();
        
        do
        {
            System.out.println("Option 1 - Add new products");
            
            System.out.println("Option 2 - Remove products");
            
            System.out.println("Option 3 - Replace products");
            
            System.out.println("Option 4 - Deliver products");
            
            System.out.println("Option 5 - Sell products");
            
            System.out.println("Option 6 - Display all products");
            
            System.out.println("Option 7 - Quit");
            
            Option = key.nextInt();
            
            System.out.println();
            
            StockApp S = new StockApp(manager);
            
            if(Option == 1)
            {
                S.AddItems();
            }
            else if(Option == 2)
            {
                S.RemoveItems();
            }
            else if(Option == 3)
            {
                S.RenameProducts();
            }
            else if(Option == 4)
            {
                S.DeliverProducts();
            }
            else if(Option == 5)
            {
                S.SellProducts();
            }
            else if(Option == 6)
            {
                S.DisplayAllProducts();
            }
        }
        while(Option != 7);
    }
}
