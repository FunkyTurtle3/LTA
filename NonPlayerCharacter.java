/**
 * @author (Lasse, Ella, Mila)
 * @version 1.1.0
 * Ein NPC (Non Player Character (dt. Nicht Spieler Charakter)) wird
 * verwendet, um alle Personen im Spiel abgesehen vom Spieler zu repräsentieren.
 */
public class NonPlayerCharacter
{
    private final String name;
    public static final NonPlayerCharacter EMPTY = new NonPlayerCharacter("");
    public NonPlayerCharacter(String name)
    {
        this.name = name;
    }

    /**
     * Gibt den Namen des NPCs zurück
     */public String getName()
    {
        return name;
    }
}