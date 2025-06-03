/**
 * Beschreiben Sie hier die Klasse Item.
 * 
 * @author (LTA)
 * @version (1.1.0)
 */
public class Item
{
    private final String name;

    public static final Item EMPTY = new Item("");

    public Item(String name) {
       this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
