/**
 * @author (Lasse, Ella, Mila)
 * @version 1.1.0
 * Items (dt. Gegenstände) können in einem Raum liegen oder im Inventar des Spielers bzw. der GameEngine existieren.
 */
public class Item
{
    private final String name; //Name des Gegenstands
    private final String description; //Beschreibung des gegenstands
    public static final Item EMPTY = new Item("", "");

    /**
     * Konstruktor für die Item-Klasse die nur den Namen benutzerdefiniert erstellt
     */
    public Item(String name) {
        this.name = name;
        this.description = "";
    }

    /**
     * Konstruktor für die Item-Klasse
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Get-Methode für das Namen-Attribut
     * @author (Ella, Mila)
     */
    public String getName()
    {
        return name;
    }

    /**
     * Get-Methode für das Beschreibungsattribut
     * @author (Ella, Mila)
     */
    public String getDescription()
    {
        return description;
    }
}
