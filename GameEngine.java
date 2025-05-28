import java.util.LinkedList;
/**
 * Beschreiben Sie hier die Klasse SpielerIn.
 * 
 * @author LTA
 * @version 1.0.0
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
        Command command = parser.createCommand(input);
        return "\nDu: " + input + "\n \n" + command.command().execute(this, command.input());
    }

    public String takeItem(String name) {
        Item item = location.takeItem(name);
        if(item != Item.EMPTY) {
            inventory.addLast(item);
            return "Ok!\n";
        } else return "Da ist kein solcher Gegenstand!";
    }

    public String toLocation(String name) {
        Location location = this.location.hasPassageTo(name);
        if(this.location != location ) {
            this.location = location;
            this.location.initPassages();
            return location.getDescription();
        } else return "Das geht leider nicht!\n";
    }

    public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equals(name)) {
                location.addItem(inventory.remove(i));
                return "Ok!\n";
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!\n";
    }
}