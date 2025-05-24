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

    public Location(String name, NonPlayerCharacter npc, LinkedList<Item> items) {
        this.name = name;
        this.npc = npc;
        this.items = items;
        this.passages = new LinkedList<>();
    }
    
    public LinkedList<Passage> getPassages()
    {
        return passages;
    }

    public void addPassage(Passage passage) {
        passages.add(passage);
    }

    public void addItem(Item item) {
        items.add(item);
    }
    
    public LinkedList<Item> getItems()
    {
        return items;
    }

    public String getDescription() {
        String description = "";
        return getGeneralDescription() + "\n\n" + description;
    }

    protected abstract String getGeneralDescription();
    
    public Location hasPassageTo(String name) {
        for(int i = 0; i < passages.size(); i++) {
            if(passages.get(i).name().toLowerCase().equals(name.toLowerCase())) return passages.get(i).location();
        }
        return this;
    }

    public Item hasItemAndDelete(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().toLowerCase().equals(name.toLowerCase())) return items.remove(i);
        }
        return Item.EMPTY;
    }
    
    public NonPlayerCharacter hasNPC(String name)
    {
        if(npc.getName().equals(name))
        {
            return npc;
        }
        return NonPlayerCharacter.EMPTY;
    }

    public void onEnter() {
        initPassages();
    }

    protected abstract void initPassages();
}