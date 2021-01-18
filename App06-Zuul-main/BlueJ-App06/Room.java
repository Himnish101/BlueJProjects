import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;
import java.util.*;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Room 
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    ArrayList<KeyItems> RoomItems = new ArrayList<KeyItems>();

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        
        for(String exit : keys) 
        {
            returnString += " " + exit;
        }
        
        returnString += "\n The current item in this area: ";
            
        returnString += OutputItems(); 
        
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    public KeyItems GetRoomItems(int index)
    {
        return RoomItems.get(index);
    }
    
    
    public void AddRoomItems(KeyItems K)
    {
        RoomItems.add(K);
    }
    
    public String OutputItems()
    {
        String Output = "";

        for(int i = 0; i < RoomItems.size(); i++)
        {   
            Output += RoomItems.get(i).GetKeyItems();
        }
        
        return Output;
    }
    
    public KeyItems GetItems(String ItemName)
    {
        KeyItems toReturn = null;
        
        for(int i = 0; i < RoomItems.size(); i++)
        {
            if(RoomItems.get(i).GetKeyItems().equals(ItemName))
            {
                return RoomItems.get(i);
            }
        }   
        return null;
    }
    
    public KeyItems GetItem2(String ItemName)
    {
        KeyItems toReturn = null;
        
        for(int i = 0; i < RoomItems.size(); i++)
        {
            return RoomItems.get(i);
        }
        
        return null;
    }
    
    public void PickItems(String ItemName)
    {
        for(int i = 0; i < RoomItems.size(); i++)
        {
            if(RoomItems.get(i).GetKeyItems().equals(ItemName))
            {
                RoomItems.remove(i);
            }
        }
    }
}

