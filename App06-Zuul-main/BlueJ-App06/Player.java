
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player
{   
    private static int points = 0;
    
    private static int stamina = 0;

    public int AddPoints()
    {
        return points += 20;
    }
    
    public int ReduceStamina()
    {
        return stamina -= 50;
    }
    
    public int AddStamina()
    {
        return stamina += 200;
    }
}
