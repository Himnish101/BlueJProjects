/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author David J. Barnes and Michael Kölling.
 * @version 2016.02.29
 */

import java.util.*;

public class StockDemo
{
    static Scanner key = new Scanner(System.in);
    
    // The stock manager.
    private StockManager manager;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockManager manager)
    {
        this.manager = manager;
        
        // Add at least 10 products, they do not have to be mobiles
        // Make sure the ids are sequential numbers
        
        manager.addProduct(new Product(101, "Samsung Galaxy S20"));
        manager.addProduct(new Product(102, "Apple iPhone 12"));
        manager.addProduct(new Product(103, "Google Pixel 4A"));
        manager.addProduct(new Product(104, "IPad"));
        manager.addProduct(new Product(105, "Xbox Series X"));
        manager.addProduct(new Product(106, "Playstation 5"));
        manager.addProduct(new Product(107, "Nintendo Switch"));
        manager.addProduct(new Product(108, "sd cards"));
        manager.addProduct(new Product(109, "USB drives"));
        manager.addProduct(new Product(110, "Canon EOS 4000D DSLR kit"));
    }
    
    /**
     * Provide a demonstration of how the StockManager meets all
     * the user requirements by making a delivery of each product 
     * re-stocking it by various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.
        
        manager.printAllProducts();        
    }
    
    public void demoDeliverProducts()
    {
        int id;
        
        int amount;
        
        System.out.println("What item do you need to restock (by id)?");
       
        id = key.nextInt();
        
        System.out.println();
        
        System.out.println("How much do you re-stock on this item.");
        
        amount = key.nextInt();
        
        manager.deliverProduct(id, amount);
    }

    public void demoSellProducts()
    {
        int id;
        
        int amount;
        
        System.out.println("What item you want to buy? (by id)");
        
        id = key.nextInt();
        
        System.out.println();
        
        System.out.println("How many do you want to buy of this item?");
        
        amount = key.nextInt();
        
        manager.sellProduct(id, amount);
    }
    
    private void RenameProducts()
    {
        String ChooseName;
        
        String RenameItems;
        
        int Index;
        
        int ID;
        
        System.out.println("Choose the item you want to rename: ");
        
        ChooseName = key.next();
        
        ID = key.nextInt();
        
        System.out.println();
        
        Index = key.nextInt();
        
        System.out.println();
        
        System.out.println("What do you want to rename the item as?");
        
        RenameItems = key.next();
        
        manager.ReplaceName(Index, new Product(ID, RenameItems));
        
        manager.printAllProducts();
    }
    
    public void RemoveItems()
    {
        String RItems;
        
        int ID;
        
        System.out.println("What item do you want to remove?");
        
        RItems = key.next();
        
        System.out.println();
        
        ID = key.nextInt();
        
        manager.RemoveName(new Product(ID, RItems));
        
        manager.printAllProducts();
    }
    
    public void AddItems()
    {
        String AItems;
        
        int ID;
        
        System.out.println("What item do you want to add?");
        
        System.out.println();
        
        AItems = key.next();
        
        System.out.println();
        
        ID = key.nextInt();
        
        System.out.println();
        
        manager.addProduct(new Product(ID,AItems));
    }
}
