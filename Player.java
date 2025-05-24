import java.util.LinkedList;
/**
 * Beschreiben Sie hier die Klasse SpielerIn.
 * 
 * @author Mila D. und Ella S. 
 * @version 1.1
 */
public class Player
{
    private final Map map;
    private final LinkedList<Item> inventory;
    private Location location;
    private final Parser parser;

    /**
     * Konstruktor für Objekte der Klasse SpielerIn
     */
    public Player()
    {
        this.map = new Map();
        this.location = map.getStartLocation();
        this.inventory = new LinkedList<>();
        parser = new Parser();
    }

    public void input(String input) {
        System.out.println("\nDu: " + input + "\n"); 
        Command command = parser.createCommand(input);
        System.out.println("Spiel: " + command.command().execute(this, command.input()));
    }

    public String takeItem(String name)
    {
        Item item = location.hasItemAndDelete(name);
        if(item != Item.EMPTY) {
            inventory.addLast(item);
            return "Ok!";
        } else return "Da ist kein solcher Gegenstand!";
    }

    public String toLocation(String name) {
        Location location = this.location.hasPassageTo(name);
        if(this.location != location ) {
            this.location = location;
            this.location.initPassages();
            return location.getDescription();
        } else return "Das geht leider nicht!";
    }

    public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equals(name)) {
                location.addItem(inventory.remove(i));
                return "Ok!";
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!";
    }

    public String invalidInput(String input) {
        return "Das verstehe ich nicht";
    }
}