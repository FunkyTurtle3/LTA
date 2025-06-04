import java.util.LinkedList;

/**
 * Beschreiben Sie hier die Klasse Map.
 * 
 * @author (LTA)
 * @version (1.0.0)
 */
public class Map
{
    public final Location START_ROOM;
    public final Location AULA;
    public final Location SCHULHOF;
    public final Location CAFETERIA;
    /**
    public final Location S01;
    public final Location S02;
    public final Location S03;
    public final Location S04;
    public final Location S05;
    public final Location S11;
    public final Location S12;
    public final Location S13;
    public final Location S14;
    public final Location S15;
    public final Location S21;
    public final Location S22;
    public final Location S23;
    public final Location S24;
    public final Location S25;
    public final Location S26;
    public final Location S27;

    public final Location N01;
    public final Location N02;
    public final Location N03;
    public final Location N04;
    public final Location N05;
    public final Location N11;
    public final Location N12;
    public final Location N13;
    public final Location N14;
    public final Location N15;
    public final Location N21;
    public final Location N22;
    public final Location N23;
    public final Location N24;
    public final Location N25;
     */
    public Map() {
        START_ROOM = new Location(
            "Start_Room",
            NonPlayerCharacter.EMPTY,
            new LinkedList<>(),
        "");

        AULA = new Location(
            "Aula",
            new NonPlayerCharacter("Frau Thies"),
            new LinkedList<>(),
        "Du befindest dich in der Aula");

        SCHULHOF = new Location(
            "Schulhof",
            new NonPlayerCharacter("Herr Alik"),
            new LinkedList<>(),
        "Alles grün hier");

        CAFETERIA = new Location(
            "Cafeteria",
            new NonPlayerCharacter("Ablas Schwester oder so"),
            new LinkedList<>(),
        "Schade dass Abla weg ist");

        START_ROOM.addPassage(AULA);
        AULA.addPassage(SCHULHOF).addPassage(CAFETERIA);
        SCHULHOF.addPassage(AULA);
        CAFETERIA.addPassage(AULA);

        AULA.addItem(new Item("Capri Sonne"));
        SCHULHOF.addItem(new Item("Stein"));
    }

    public Location getStartLocation() {
        return START_ROOM;
    }
}