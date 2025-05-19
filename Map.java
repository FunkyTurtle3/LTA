import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Map.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Map
{
    private final Location AULA = new Location("Aula", new NonPlayerCharacter(), new LinkedList<Item>()
    , new LinkedList<Exit>()) 
    {
        public String getGeneralDescription() {
            return "Hier steht Frau Thieß mmmmmh...";
        }
    };

}
