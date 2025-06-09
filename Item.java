/**
 * @author (Lasse, ELla, Mila)
 * @version 1.1.0
 * Items (dt. Gegenstände) können in einem Raum liegen oder im Inventar des Spielers bzw. der GameEngine existieren.
 */
public class Item
{
    private final String name; //Name des Gegenstands

    public static final Item EMPTY = new Item("");
    /**
     * Konstruktor für die Item-Klasse die nur den Namen initialisiert
     */
    public Item(String name) {
       this.name = name;
    }

    /**
     * Get-Methode für das Namen-Attribut
     * @author (Ella, Mila)
     */
    public String getName()
    {
        return name;
    }
}
