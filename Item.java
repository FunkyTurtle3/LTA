/**
 * @author (Lasse, ELla, Mila)
 * @version 1.1.0
 * Items (dt. Gegenstaende) koennen in einem Raum liegen oder im Inventar des Spielers bzw. der Game Engine existieren.
 */
public class Item
{
    private final String name; //Name des Gegenstands

    public static final Item EMPTY = new Item("");

    public Item(String name) {
       this.name = name;
    } //Konstruktor fuer die Item-Klasse die nur den Namen initialisisert
    
    public String getName()
    {
        return name;
    } //Get-Methode fuer das Namen-Attribut
}
