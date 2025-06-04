import java.util.LinkedList;
/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Objekte dieser Klasse sind die Herzstücke von Spielinstanzen.
 * Sie regeln alle rechnerischen Vorgänge und kontrollieren, was der Spieler zu sehen bekommt.
 */
public class GameEngine
{
    private final LinkedList<Item> inventory;
    private Location location;
    private final Parser parser;

    public GameEngine() {
        Map map = new Map();
        this.location = map.getStartLocation();
        this.inventory = new LinkedList<>();
        parser = new Parser();
    }

    public String input(String input) {
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

    public String getInfo() {
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

    public String getInventoryDescription() {
        StringBuilder des = new StringBuilder();
        for (Item item : inventory) {
            des.append(item.getName()).append("\n");
        }
        return des.toString();
    }

    public String reset(String input) {
        if(input.equalsIgnoreCase("neu")) {
            Map map = new Map();
            this.location = map.getStartLocation();
            return "";
        } else if(input.equalsIgnoreCase("spiel") && this.location.getName().equalsIgnoreCase("Start_Room")) {
            return toLocation("Aula");
        } else return "Gebe \"Starte neu/Spiel\" ein um erneut zu beginnen!\n";
    }

    public String takeItem(String name) {
        Item item = location.takeItem(name);
        if(item != Item.EMPTY) {
            inventory.addLast(item);
            return "Ok!\n";
        } else return "Da ist kein solcher Gegenstand!\n";
    }

    public String toLocation(String name) {
        Location location = this.location.hasPassageTo(name);
        if(this.location != location) {
            this.location = location;
            return location.getDescription();
        } else return "Das geht leider nicht!\n";
    }

    public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name)) {
                location.addItem(inventory.remove(i));
                return "Ok!\n";
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!\n";
    }
}