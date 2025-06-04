import java.util.LinkedList;
/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Objekte dieser Klasse sind das Zentrum von Spielinstanzen.
 * In dieser Klasse werden alle Mothoden und Befehle die fuer den Spielverlauf relevant sind zusammengefuehrt
 */
public class GameEngine
{
    private final LinkedList<Item> inventory;
    private Location location;
    private final Parser parser;

    /**
     * Konstruktor der GameEngine Klasse
     * @author
     */public GameEngine() {
        Map map = new Map();
        this.location = map.getStartLocation();
        this.inventory = new LinkedList<>();
        parser = new Parser();
    }

    /**
     * Fuehrt eingabenspezifische Methoden aus
     * @author
     */public String input(String input) {
        Command command = parser.createCommand(input.toLowerCase());
        String output = "";

        switch (command.command()) {
            case ZU -> output = toLocation(command.input());
            case GIB -> output = dropItem(command.input());
            case NIMM -> output = takeItem(command.input());
            case STARTE -> output = reset(command.input());
            case INFO -> output = getInfo();
            case INVALIDINPUT -> output = "Das verstehe ich nicht!\n";
        }

        return "\nDu: " + input + "\n \n" + output;
    }

    /**
     * Methode die die Spielfunktionen beschriebt sobald der Spieler sie abfragt
     * @author
     */public String getInfo() {
        return """
                Du befindest dich am Leibniz-Gymnasium,
                hier musst du ein Quiz abschließen um den großen Preis zu gewinnen.
                
                Die Befehle die du nutzen kannst lauten:\
                
                "Starte neu": um das Spiel von vorne zu beginnen\
                
                "Info": um Informationen über die Spielweise zu erhalten\
                
                "Zu <Raum>": um zu einem anderen Ort zu gehen\
                
                "Nimm <Gegenstand>": um einen Gegenstand aufzuheben\
                
                "Gib <Gegenstand>": um einen Gegenstand abzulegen\
                
                """;
    }

    /**
     *Methode zum Zurueckgeben des Inhalts des Spielerinventars in From eines Strings
     * @author
     */public String getInventoryDescription() {
        StringBuilder des = new StringBuilder();
        for (Item item : inventory) {
            des.append(item.getName()).append("\n");
        }
        return des.toString();
    }

    /**
     * Setzt das Spiel auf den Anfang zurueck
     * @author
     */public String reset(String input) {
        if(input.equalsIgnoreCase("neu")) {
            Map map = new Map();
            this.location = map.getStartLocation();
            return "";
        } else if(input.equalsIgnoreCase("spiel") && this.location.getName().equalsIgnoreCase("Start_Room")) {
            return toLocation("Aula");
        } else return "Gebe \"Starte neu/Spiel\" ein um erneut zu beginnen!\n";
    }

    /**
     * Diese methode versucht einen Gegenstand aus einem Raum/Ort in das Inventar zu platzieren
     * @author
     */public String takeItem(String name) {
        Item item = location.takeItem(name);
        if(item != Item.EMPTY) {
            inventory.addLast(item);
            return "Ok!\n";
        } else return "Da ist kein solcher Gegenstand!\n";
    }

    /**
     * Diese Methode versucht den Spieler in einen anliegenden Raum/Ort zu bewegen
     * @author
     */public String toLocation(String name) {
        Location location = this.location.hasPassageTo(name);
        if(this.location != location) {
            this.location = location;
            return location.getDescription();
        } else return "Das geht leider nicht!\n";
    }

    /**
     *Versucht einen Gegenstand aus dem Inventar in den Raum/Ort zu platzieren
     * @author ()
     */public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name)) {
                location.addItem(inventory.remove(i));
                return "Ok!\n";
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!\n";
    }
}