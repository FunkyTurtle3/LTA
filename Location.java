import java.util.LinkedList;

/**
 * Objekte der Klasse Location (dt. Ort) beinhalten alle notwendigen Informationen über alle Rauume des Leibniz-Gymnasiums.
 * Eine Location repraesentiert digital einen Raum.
 * @author (Lasse, Victor, Leander, Ella, Mila)
 * @version (1.1.0)
 */
public class Location
{
    private final String name; //Name des Raumes/Ortes
    private final NonPlayerCharacter npc; //Speichert den NPC der sich im Raum/Ort befindet

    private final LinkedList<Item> items; //Stellt eine Liste zum Speichern von Gegenständen bereit
    private final LinkedList<Location> passages; //Stellt eine Liste zum Speichern von Durchgängen bereit
    private final String description; //Attribut welches zur Beschreibung des Raum/Ort dient

    /**
     * Konstruktor der Location Klasse
     */
    public Location(String name, NonPlayerCharacter npc, LinkedList<Item> items, String description) {
        this.name = name;
        this.npc = npc;
        this.items = items;
        this.description = description;
        this.passages = new LinkedList<>();
    }

    /**
     * gibt eine Liste aller Ausgänge zurück
     */public LinkedList<Location> getPassages()
    {
        return passages;
    }

    /**
     * gibt den Namen des Raumes/Orts zurück
     */public String getName() {
        return name;
    }

    /**
     * Diese Methode dient dazu neue Ausgänge zu einem Raum/Ort hinzuzufügen
     */public Location addPassage(Location passage) {
        passages.add(passage);
        return this;
    }

    /**
     * Diese Methode dient dazu neue Gegenstände zu einem Raum/Ort hinzuzufügen
     */public void addItem(Item item) {
        items.add(item);
    }

    /**
     * gibt eine Liste aller Gegenstände zurück
     */public LinkedList<Item> getItems()
    {
        return items;
    }

    /**
     * gibt eine Beschreibung des Raumes inklusive NPCs, Gegenständen oder Ausgängen zurück
     */public String getDescription() {
        StringBuilder description = new StringBuilder();
        if(!items.isEmpty()) description.append("Hier findest du: ").append(this.getItemDescription()).append("\n");
        if(!passages.isEmpty()) description.append("Von hier gelangst du zu: ").append(this.getPassageDescription()).append("\n");
        if(npc != NonPlayerCharacter.EMPTY) description.append(npc.getName()).append(" wartet bereits auf dich").append("\n");
        return getGeneralDescription() + "\n\n" + description;
    }

    /**
     * gibt die Standardbeschreibung des jeweiligen Orts zurück
     */protected String getGeneralDescription()
    {
        return this.description;
    }

    public Location hasPassageTo(String name) {
        for(int i = 0; i < passages.size(); i++) {
            if(passages.get(i).getName().equalsIgnoreCase(name)) return passages.get(i);
        }
        return this;
    }

    public Item takeItem(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equalsIgnoreCase(name)) return items.remove(i);
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

    public String getItemDescription()
    {
        LinkedList<String> x = new LinkedList<>();
        for(int i = 0; i < this.getItems().size(); i++)
        {
            x.add(this.getItems().get(i).getName());
        }
        return x.toString().substring(1, x.toString().length() - 1);
    }

    public String getPassageDescription()
    {
        LinkedList<String> x = new LinkedList<>();
        for(int p = 0; p < passages.size(); p++)
        {
            x.add(passages.get(p).getName());
        }
        return x.toString().substring(1, x.toString().length() - 1);
    }
}