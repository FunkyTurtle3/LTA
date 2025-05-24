import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Location.
 * 
 * @author (LTA) 
 * @version (1.0.0)
 */
public abstract class Location
{
    private final String name;
    private final NonPlayerCharacter npc;

    private final LinkedList<Item> items;
    private final LinkedList<Passage> passages; //Exit = Record

    public Location(String name, NonPlayerCharacter npc, LinkedList<Item> items, LinkedList<Passage> passages) {
        this.name = name;
        this.npc = npc;
        this.items = items;
        this.passages = passages;
    }

    public String getDescription() {
        String description = "";
        return getGeneralDescription() + "\n\n" + description;
    }
    
    public LinkedList<Passage> getPassages()
    {
        return passages;
    }
    
    public LinkedList<Item> getItems()
    {
        return items;
    }

    protected abstract String getGeneralDescription();
    
    public Location hasPassageTo(String name) {
        for(int i = 0; i < passages.size(); i++) {
            if(passages.get(i).name() == name) return passages.get(i).location();
        }
        return this;
    }
    
    public Item hasItem(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equals(name)) return items.get(i);
        }
        return Item.EMPTY;
    }
    
    public NonPlayerCharacter hasNPC(String name)
    {
        if(npc.getName() == name)
        {
            return npc;
        }
        return NonPlayerCharacter.EMPTY;
    }
}