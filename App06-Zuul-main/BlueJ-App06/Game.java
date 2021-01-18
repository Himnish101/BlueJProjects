/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * 
 * Modified and extended by Your name
 */

import java.util.*;

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    ArrayList<KeyItems> Inventory = Inventory = new ArrayList<KeyItems>();
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office, library, gym, p3d, hall, storage, PropStudio, Floor2;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university.");
        theater = new Room("in a lecture theater.");
        PropStudio = new Room("in the prop studio.");
        pub = new Room("in the campus pub.");
        lab = new Room("in a computing lab.");
        office = new Room("in the computing admin office.");
        library = new Room("in the library, time to READ A BOOK.");
        Floor2 = new Room("in the second floor of the library.");
        gym = new Room("in the gym, time for exercise.");
        p3d = new Room("in the 3D Printer room. Time to print the 3D project");
        hall = new Room("meet up with a friend who wants to play badminton but in order to play you need racquets.");
        storage = new Room("in the storage room.");
        
        // initialise room exits
        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);

        theater.setExit("west", outside);
        theater.setExit("downstairs", PropStudio);
        theater.AddRoomItems(new KeyItems("Props"));
        
        PropStudio.setExit("upstairs", theater);

        pub.setExit("east", outside);

        lab.setExit("north", outside);
        lab.setExit("east", office);
        lab.setExit("south", library);
        lab.setExit("west", p3d);

        office.setExit("west", lab); // New stuff to mention
        
        office.AddRoomItems(new KeyItems("Keys"));
        
        library.setExit("east", gym);
        
        library.setExit("north", lab);
        
        library.setExit("lift", Floor2);
        
        Floor2.setExit("lift", library);
        
        Floor2.AddRoomItems(new KeyItems("Book"));
        
        gym.setExit("west", library);
        
        gym.setExit("north", hall);
        
        gym.setExit("Back", storage);
        
        p3d.setExit("east", library);
        
        p3d.AddRoomItems(new KeyItems("Project"));
        
        hall.setExit("south", gym);
        
        storage.setExit("forward", gym);
        
        storage.AddRoomItems(new KeyItems("Racquets"));

        currentRoom = outside;  // start game outside
        
        Inventory.add(new KeyItems("Student ID Card"));
        
        Inventory.add(new KeyItems("Trainers"));
        
        Inventory.add(new KeyItems("£7.60"));
    }
    
    public void DisplayInventory()
    {
        System.out.println("Your current item in your inventory is: \n");
        
        for(int i = 0; i < Inventory.size(); i++)
        {   
            String Output = Inventory.get(i).GetKeyItems();
            
            System.out.println(Output);
            
            System.out.println("\n");
        }
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        
        while (! finished) 
        {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        
        System.out.println("Thank you for playing my game.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) 
        {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;
            
            case INVENTORY:
                DisplayInventory();
                break;
            
            case PICKUPITEM:
                GoItem(command);
                break;
            
            case USEITEM:
                UseItem(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around at the university.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door. \n");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }
    
    private void GoItem(Command command) 
    {
        if(!command.hasSecondWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Get what?");
            return;
        }

        String KeyItem = command.getSecondWord();

        KeyItems NextItem = currentRoom.GetItems(KeyItem);

        if (NextItem == null) 
        {
            System.out.println("The item can not be found here. \n");
        }
        else 
        {
            System.out.println("You found a " + KeyItem);
            
            Inventory.add(NextItem);
        }
    }
    
    private void UseItem(Command command) 
    {
        if(!command.hasSecondWord() && !command.HasThirdWord()) 
        {
            // if there is no second word, we don't know where to go...
            System.out.println("Use what?");
        }

        String KeyItem = command.getSecondWord();
        
        String RemoveItem = KeyItem;

        KeyItems NextItem = currentRoom.GetItems(KeyItem);
        
        String Room = command.getThirdWord();
        
        Activities A = new Activities();
        
        Player P = new Player();
        
        int CurrentPoints = 0;
        
        int CurrentStamina = 200;
        
        if (KeyItem == null) 
        {
            System.out.println("The item can not be used here. \n");
        }
        else if(KeyItem.equals("Props"))
        {
            A.Theater();
                    
            CurrentStamina += P.ReduceStamina();
            
            RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("£7.60"))
        {
            A.Theater();
                    
            CurrentStamina += P.ReduceStamina();
            
            RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("Project"))
        {
             A.LabA();
                    
             CurrentStamina += P.ReduceStamina();
             
             RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("Racquets"))
        {
            A.Badminton();
                    
            CurrentStamina += P.ReduceStamina();
            
            RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("Keys"))
        {
              A.P3D();
                    
              CurrentStamina += P.ReduceStamina();
              
              RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("Book"))
        {
             A.ReadBook();
                   
             CurrentStamina += P.ReduceStamina();
             
             RemoveInventory(RemoveItem);
        }
        else if(KeyItem.equals("Trainers"))
        {
             A.Sprint();
                    
             CurrentStamina += P.ReduceStamina();
             
             RemoveInventory(RemoveItem);
        }
        
        CurrentPoints += P.AddPoints();
                
        System.out.println("Points: " + CurrentPoints + "\n");
                
        System.out.println("Stamina: " + CurrentStamina + "\n");
                
        if(CurrentPoints == 140)
        {
            System.out.println("Congratulations! \n");
                    
            System.out.println("You've won the game.");
        }
                
        if(CurrentStamina > 20 && CurrentStamina <= 50)
        {
            System.out.println("You're running low on stamina. \n");
                    
            System.out.println("Please rest up. \n");
        }
        else if(CurrentStamina <= 20)
        {
            System.out.println("Unfortunately, you weren't able to keep up with your stamina. \n");
                    
            System.out.println("As a result, you have lost the game. \n");
        }  
    }
    
    public void RemoveInventory(String I)
    {
        for(int i = 0; i < Inventory.size(); i++)
        {
            if(Inventory.get(i).GetKeyItems().equals(I))
            {
                Inventory.remove(I);
            }
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
