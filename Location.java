import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Location.
 * 
 * @author (LTA) 
 * @version (1.0.0)
 */
public abstract class Location
{
    private String name;
    private NonPlayerCharacter npc;

    private LinkedList<Item> items;
    private LinkedList<Exit> exits; //Exit = Record

    public Location(String name, NonPlayerCharacter npc, LinkedList<Item> items, LinkedList<Exit> exits) {
        this.name = name;
        this.npc = npc;
        this.items = items;
        this.exits = exits;
    }

    public String getDescription() {
        String description = "";
        return getGeneralDescription() + "\n\n" + description;
    }

    public abstract String getGeneralDescription();

}
