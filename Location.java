import java.util.LinkedList;

/**
 * Objekte der Klasse Location (dt. Ort) beinhalten alle notwendigen Informationen über alle Räume des Leibniz-Gymnasiums.
 * Eine Location repräsentiert digital einen Raum.
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

    private boolean locked; //Attribut zur Überprüfung, ob ein Raum verschlossen ist
    private final Item unlockItem;

    /**
     * Konstruktor der Location Klasse
     * @author (Mila,Ella)
     */
    public Location(String name, NonPlayerCharacter npc, String description, Item unlockItem) {
        this.name = name;
        this.npc = npc;
        this.items = new LinkedList<>();
        this.description = description;
        this.passages = new LinkedList<>();
        this.unlockItem = unlockItem;
        if(unlockItem != Item.EMPTY) this.locked = true;
    }

    /**
     * Konstruktor der Location Klasse
     * @author (Mila,Ella)
     */
    public Location(String name, NonPlayerCharacter npc, String description) {
        this(name, npc, description, Item.EMPTY);
    }

    /**
     * gibt den Namen des Raumes/Orts zurück
     */
    public String getName() {
        return name;
    }

    public Item getUnlockItem() {
        return this.unlockItem;
    }

    /**
     * Diese Methode dient dazu neue Ausgänge zu einem Raum/Ort hinzuzufügen
     */
    public Location addPassage(Location passage) {
        passages.add(passage);
        return this;
    }

    /**
     * Diese Methode dient dazu neue Gegenstände zu einem Raum/Ort hinzuzufügen
     */
    public void addItem(Item item) {
        items.add(item);
    }

    /**
     * Gibt eine Liste aller Gegenstände zurück
     */
    public LinkedList<Item> getItems()
    {
        return items;
    }

    /**
     * Gibt eine Beschreibung des Raumes inklusive NPCs, Gegenständen oder Ausgängen zurück
     */
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        if(!items.isEmpty()) description.append("Hier findest du: ").append(this.getItemDescription());
        if(!passages.isEmpty()) description.append("\n").append("Von hier gelangst du zu: ").append(this.getPassageDescription());
        if(npc != NonPlayerCharacter.EMPTY) description.append("\n").append(npc.getName()).append(" wartet bereits auf dich");
        return getGeneralDescription() + "\n\n" + description;
    }

    /**
     * gibt die Standardbeschreibung des jeweiligen Orts zurück
     */
    protected String getGeneralDescription()
    {
        return this.description;
    }

    /**
     * Testet, ob der aktuelle Ort einen Zugang zu dem eingegebenen Ort hat
     * @author (Lasse, Ella, Mila)
     */
    public Location hasPassageTo(String name) {
        for(int i = 0; i < passages.size(); i++) {
            if(passages.get(i).getName().equalsIgnoreCase(name)) return passages.get(i);
        }
        return null;
    }

    /**
     * Platziert wenn möglich einen Gegenstand im Inventar des Spielers
     * @author
     */
    public Item takeItem(String name) {
        for(int i = 0; i < items.size(); i++) {
            if(items.get(i).getName().equalsIgnoreCase(name)) return items.remove(i);
        }
        return Item.EMPTY;
    }

    public NonPlayerCharacter getNPC() {
        return npc;
    }

    /**
     * Gibt eine Beschreibung der Gegenstände in einem Raum zurück
     * @author (Mila, Lasse, Ella)
     */
    public String getItemDescription()
    {
        LinkedList<String> x = new LinkedList<>();
        for(int i = 0; i < this.getItems().size(); i++)
        {
            x.add(this.getItems().get(i).getName());
        }
        return x.toString().substring(1, x.toString().length() - 1);
    }

    /**
     * gibt eine Beschreibung der Ausgänge in einem Raum zurück
     * @author (Mila, Lasse, Ella)
     */
    public String getPassageDescription()
    {
        LinkedList<String> x = new LinkedList<>();
        for(int p = 0; p < passages.size(); p++)
        {
            x.add(passages.get(p).getName());
        }
        return x.toString().substring(1, x.toString().length() - 1);
    }

    /**
     * Überprüft, ob ein Raum verschlossen ist.
     * @author (Mila, Ella)
     */
    public boolean isLocked()
    {
        return locked;
    }

    /**
     * Öffnet eine Tür.
     * @author (Mila, Ella)
     */
    public void open()
    {
        locked = false;
    }
}