import java.util.LinkedList;
/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Objekte dieser Klasse sind das Zentrum von Spielinstanzen.
 * In dieser Klasse werden alle Methoden und Befehle die für den Spielverlauf relevant sind zusammengeführt
 */
public class GameEngine
{
    private final LinkedList<Item> inventory;
    private Location location;

    /**
     * Konstruktor der GameEngine Klasse
     * @author
     */public GameEngine() {
        Map map = new Map();
        this.location = map.getStartLocation();
        this.inventory = new LinkedList<>();
    }

    /**
     * Führt eingabenspezifische Methoden aus
     * @author
     */public String input(String input) {
        Command command = Parser.createCommand(input.toLowerCase());
        String output = "";

        switch (command.command()) {
            case ZU -> output = toLocation(command.input());
            case LEGE -> output = dropItem(command.input());
            case NIMM -> output = takeItem(command.input());
            case STARTE -> output = reset(command.input());
            case SPRICH -> output = talkToNPC();
            case GIB -> output = giveNPC(command.input());
            case INFO -> output = getInfo();
            case INVALIDINPUT -> output = "Das verstehe ich nicht!\n";
        }

        return "\nDu: " + input + "\n \n" + output;
    }

    /**
     * Methode die, die Spielfunktionen beschreibt, sobald der Spieler sie abfragt
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
                
                "Lege <Gegenstand>": um einen Gegenstand abzulegen\
                
                """;
    }

    public String talkToNPC() {
         return location.getNPC().talk(Item.EMPTY).outputString() + "\n";
    }

    public String giveNPC(String input) {
        Item item = Item.EMPTY;
        int i;
        for(i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(input)) {
                item = inventory.remove(i);
            }
        }
        NPCInteraction interaction = location.getNPC().talk(item);
        if (interaction.output() != Item.EMPTY) inventory.add(i - 1, interaction.output());
        return location.getNPC().getName() + ": " + interaction.outputString() + "\n";
    }


    /**
     * Methode zum Zurückgeben des Inhalts des Spielerinventars in From eines Strings
     * @author
     */public String getInventoryDescription() {
        StringBuilder des = new StringBuilder();
        for (Item item : inventory) {
            des.append(item.getName()).append("\n");
        }
        return des.toString();
    }

    /**
     * Setzt das Spiel auf den Anfang zurück
     * @author
     */public String reset(String input) {
        if(input.equalsIgnoreCase("neu")) {
            Map map = new Map();
            this.inventory.clear();
            this.location = map.getStartLocation();
            return "";
        } else if(input.equalsIgnoreCase("spiel") && this.location.getName().equalsIgnoreCase("Start_Room")) {
            return toLocation("Aula");
        } else return "Gebe \"Starte neu/Spiel\" ein um erneut zu beginnen!\n";
    }

    /**
     * Diese Methode versucht einen Gegenstand aus einem Raum/Ort in das Inventar zu platzieren
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
     * Versucht einen Gegenstand aus dem Inventar des Spielers in den Raum/Ort zu platzieren
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