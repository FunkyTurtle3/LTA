import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Map.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Map
{
    private Location AULA;
    private Location SCHULHOF;

    public Map() {
        AULA = new Location(
            "Aula",
            new NonPlayerCharacter("Frau Thies"),
            new LinkedList<Item>(),
            new LinkedList<Passage>(Collections.singleton(new Passage("Schulhof", SCHULHOF))))
        {
            public String getGeneralDescription() {
                return "Hier steht Frau Thieß mmmmmh...";
            }
        };
        SCHULHOF = new Location(
            "Aula",
            new NonPlayerCharacter("Frau Thies"),
            new LinkedList<Item>(),
            new LinkedList<Passage>(Collections.singleton(new Passage("Aula", AULA))))
        {
            public String getGeneralDescription() {
                return "Hier steht Frau Thieß mmmmmh...";
            }
        };
    }

}