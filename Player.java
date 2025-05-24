import java.util.LinkedList;
/**
 * Beschreiben Sie hier die Klasse SpielerIn.
 * 
 * @author Mila D. und Ella S. 
 * @version 1.1
 */
public class Player
{
    private LinkedList<Item> inventory; 
    private Location location;
    private Parser parser;
    /**
     * Konstruktor für Objekte der Klasse SpielerIn
     */
    public Player(Location location)
    {
        this.location = location; 
        parser = new Parser(this);
    }

    //public int getNumberKeys()
    //{
    //    return inventory.getCount();
    //}
    
    private void setLocation(Location newLoc)
    {
        location = newLoc;
    }
    
    public void takeItem(Item newItem)
    {
        inventory.addLast(newItem);
    }
    
    public void removeItem(Item oldItem)
    {
        inventory.remove(oldItem);
    }
}
