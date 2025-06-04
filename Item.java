/**
 * @author (Lasse, ELla, Mila)
 * @version 1.1.0
 * Items (dt. Gegenstände) können in einem Raum liegen oder im Inventar des Spielers bzw. der Game Engine existieren.
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
