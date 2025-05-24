import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Map.
 * 
 * @author (LTA)
 * @version (1.0.0)
 */
public class Map
{
    public final Location AULA;
    public final Location SCHULHOF;
    public final Location CAFETERIA;

    public Map() {
        AULA = new Location(
            "Aula",
            new NonPlayerCharacter("Frau Thies"),
            new LinkedList<>())
        {
            public String getGeneralDescription() {
                return "Hier steht Frau Thieß mmmmmh...";
            }

            public void initPassages() {
                addPassage(new Passage("Schulhof", SCHULHOF));
            }
        };

        SCHULHOF = new Location(
            "Schulhof",
            new NonPlayerCharacter("Herr Alik"),
            new LinkedList<>())
        {
            public String getGeneralDescription() {
                return "Alles grün hier";
            }

            public void initPassages() {
                addPassage(new Passage("Aula", AULA));
            }
        };

        CAFETERIA = new Location(
            "Cafeteria",
            new NonPlayerCharacter("Ablas Schwester oder so"),
            new LinkedList<>())
        {
            public String getGeneralDescription() {
                return "Schade, dass Abla weg ist";
            }

            public void initPassages() {
                addPassage(new Passage("Aula", AULA));
                addPassage(new Passage("Schulhof", SCHULHOF));
            }
        };
        AULA.initPassages();
        AULA.addItem(new Item("Capri-Sonne", 3));
    }

    public Location getStartLocation() {
        return AULA;
    }
}