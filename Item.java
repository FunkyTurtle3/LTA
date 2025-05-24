
/**
 * Beschreiben Sie hier die Klasse Item.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Item
{
    private final String name;
    private final int type;
    public static final Item EMPTY = new Item("", -1);
    public Item(String name, int type) {
       this.name = name;
       this.type = type;
    }
    
    public String getName()
    {
        return name;
    }
}
