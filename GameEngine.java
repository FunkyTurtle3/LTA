import java.lang.reflect.Field;
import java.util.LinkedList;
/**
 * @author (Lasse, Leander, Victor, Ella, Mila)
 * @version 1.1.0
 * Objekte dieser Klasse sind das Zentrum von Spielinstanzen.
 * In dieser Klasse werden alle Methoden und Befehle die für den Spielverlauf relevant sind zusammengeführt
 */
public class GameEngine
{
    private final LinkedList<Item> inventory;
    private final NonPlayerCharacter quiz;
    private Map map;
    private Location location;
    private boolean isInDevMode;
    /**
     * Konstruktor der GameEngine Klasse
     * @author ()
     */public GameEngine() {
        this.map = new Map();
        this.location = map.getStartLocation();
        this.inventory = new LinkedList<>();
        this.quiz = new NonPlayerCharacter("")
            .addInteraction(new NPCInteraction("Seit welchem Jahr ist es Schülerinnen erlaubt am Leibniz Gymnasium zu lernen?", Item.EMPTY, Item.EMPTY)) //Geschichte? - not solvable
            .addInteraction(new NPCInteraction("Wie viele Räume hat das Gebäude des Leibniz-Gymnasiums insgesamt?", new Item("1900"), Item.EMPTY)) //Hausmeister - solvable
            .addInteraction(new NPCInteraction("Wie lautet die Zahl 175 im Binärcode?", new Item("94"), Item.EMPTY)) //Informatik - solvable
            .addInteraction(new NPCInteraction("Nach welcher Person, wurde die Schule vor Gottfried Wilhelm Leibniz benannt?", new Item("10101111"), Item.EMPTY)) //Geschichte - not solvable
            .addInteraction(new NPCInteraction("Auf welchen Koordinaten befindet sich das Gebäude des Leibniz-Gymnasium?", new Item("Robert Koch"), Item.EMPTY)) //Geografie - solvable
            .addInteraction(new NPCInteraction("Welchen Namen trug der Architekt des Gebäudes vom Leibniz-Gymnasium?", new Item("52° N, 13° O"), Item.EMPTY)) //Kunst - solvable
            .addInteraction(new NPCInteraction("Wann wurde das Leibniz-Gymnasium erstmals als MINT-freundliche Schule ausgezeichnet?", new Item("Ludwig Hoffmann"), Item.EMPTY)) //Schulleitung - not solvable
            .addInteraction(new NPCInteraction("Mit wie viel Prozent der Stimmen gewann die Parte \"Die Linke\" 2025 die Juniorwahl?", new Item("2013"), Item.EMPTY)) //Politik - not solvable
            .addInteraction(new NPCInteraction("Welcher Epoche lässt sich Gottfried Wilhelm Leibniz's Person zuordnen?", new Item("39,8", ""), Item.EMPTY)) //Deutsch - solvable
            .addInteraction(new NPCInteraction("Schreibe die Ordnungszahlen der Chemischen Elemente auf\nmit welchen durch die Anfangsbuchstaben des Elementsymbols das Wort Leibniz gebildet werden kann.\nEs gilt immer die kleinstmögliche Zahl.", new Item("Aufklärung", ""), Item.EMPTY)) //Chemie - solvable
            .addInteraction(new NPCInteraction("Nächste Frage", new Item("3 63 53 4 7 53 30", ""), Item.EMPTY));
        this.isInDevMode = false;
    }

    /**
     * Führt eingabenspezifische Methoden aus
     * @author (Mila, Ella, Lasse, Leander)
     */public String input(String input) {
        Command command = Parser.createCommand(input.toLowerCase());
        String output = "";

        switch (command.command()) {
            case ZU -> output = toLocation(command.input());
            case LEGE -> output = dropItem(command.input());
            case NIMM -> output = takeItem(command.input());
            case STARTE -> output = start(command.input());
            case FRAG -> output = talkToNPC();
            case GIB -> output = giveNPC(command.input());
            case INFO -> output = getInfo();
            case INSPIZIERE -> output = getItemDescription(command.input());
            case OEFFNE -> output = openDoor(command.input());
            case ANTWORTE -> output = answerQuiz(command.input());
            case INVALIDINPUT -> output = "Das verstehe ich nicht!";
            case SUDODEVELOPERMODE -> {this.isInDevMode = true; output = "Du bist jetzt im Entwickler-Modus";}
        }

        return "\nDu: " + input + "\n \n" + output + "\n\n";
    }

    public String answerQuiz(String input) {
        if(!this.location.getName().equals("Aula")){
            return "Du musst in der Aula sein um das Quiz zu machen";
        } else if (this.quiz.getTimesInteracted() <= 0) {
            return "Benutze den \"Starte Quiz\"-Befehl um das Quiz zu starten";
        } else return quiz.talk(new Item(input, "")).outputString();
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
                
                "Starte Quiz": um das Quiz in der Aula zu starten\
                
                "Info": um Informationen über die Spielweise zu erhalten\
                
                "Zu <Raum>": um zu einem anderen Ort zu gehen\
                
                "Nimm <Gegenstand>": um einen Gegenstand aufzuheben\
                
                "Lege <Gegenstand>": um einen Gegenstand abzulegen\
                
                "Inspiziere <Gegenstand>": um einen Gegenstand zu untersuchen\
                
                "Frag": um mit Personen zu Sprechen\
                
                "Gib <Gegenstand>": um mit Personen zu sprechen\
                
                "Oeffne <Raum>": um eine Tür zu einem Raum zu öffnen\
                
                "Antworte <Antwort>": um eine Frage des Quizes zu beantworten\
                
                """;
    }

    public String talkToNPC() {
        return location.getNPC().getName() + ": " + location.getNPC().talk(Item.EMPTY).outputString();
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
        return location.getNPC().getName() + ": " + interaction.outputString();
    }

    /**
     * Methode zum Zurückgeben des Inhalts des Spielerinventars in From eines Strings
     * @author
     */
    public String getInventoryDescription() {
        StringBuilder des = new StringBuilder();
        for (Item item : inventory) {
            des.append(item.getName()).append("\n");
        }
        return des.toString();
    }

    /**
     * Setzt das Spiel auf den Anfang zurück
     * @author
     */
    public String start(String input) {
        if(input.equalsIgnoreCase("neu")) {
            this.map = new Map();
            this.inventory.clear();
            this.location = map.getStartLocation();
            this.isInDevMode = false;
            return "";
        } else if(input.equalsIgnoreCase("spiel") && this.location.getName().equals("Start_Room")) {
            return toLocation("Aula");
        } else if(input.equalsIgnoreCase("quiz") && this.location.getName().equals("Aula") && quiz.getTimesInteracted() == 0) {
            return quiz.talk(Item.EMPTY).outputString();
        } else return "Gebe \"Starte neu/Spiel/Quiz\" ein ";
    }

    /**
     * Diese Methode versucht einen Gegenstand aus einem Raum/Ort in das Inventar zu platzieren
     * @author
     */
    public String takeItem(String name) {
        Item item = location.takeItem(name);
        if(item.getName().equals("Beutel voller Termit") && !isInDevMode) System.exit(0);
        if(item != Item.EMPTY) {
            inventory.addLast(item);
            return "Ok!";
        } else return "Da ist kein solcher Gegenstand!";
    }

    /**
     * Diese Methode versucht den Spieler in einen anliegenden Raum/Ort zu bewegen
     * @author (Mila, Ella)
     */
    public String toLocation(String name) {
        if (isInDevMode) {
            try {
                Field feld = this.map.getClass().getField(name.toUpperCase());  // Sucht nur public Felder
                Object wert = feld.get(map);
                this.location = (Location) wert;
                return location.getDescription();
            } catch (Exception e) {
                System.out.println("Location '" + name + "' existiert nicht oder ist nicht public.");
            }
        } //Hilfe durch https://chatgpt.com
        Location location = this.location.hasPassageTo(name);
        if(!location.isLocked())
        {
            if(location != null) {
                this.location = location;
                return location.getDescription();
            } else return "Das geht leider nicht!";
        }
        else return "Der Raum ist verschlossen!";
    }

    /**
     * Versucht einen Gegenstand aus dem Inventar des Spielers in den Raum/Ort zu platzieren
     * @author ()
     */public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name)) {
                location.addItem(inventory.remove(i));
                return "Ok!";
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!";
    }

    /**
     * Gibt eine Beschreibung eines bestimmten Gegenstandes zurück.
     * @author (Mila, Ella)
     */
    public String getItemDescription(String name)
    {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name))
            {
                return inventory.get(i).getDescription();
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!";
    }

    /**
     * Versucht verschlossene Türen zu öffnen, wenn der Spieler einen Schlüssel hat.
     * @author (Mila, Ella)
     */
    public String openDoor(String name)
    {
        if(location.hasPassageTo(name).isLocked()) {
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).getName().equalsIgnoreCase(location.hasPassageTo(name).getUnlockItem().getName())) {
                    location.hasPassageTo(name).open();
                    return "Die Tür ist jetzt geöffnet.";
                } else return "Fehler in der If-Anweisung";
            }
            return "Du hast keinen Schlüssel.";
        }
        else if(location.hasPassageTo(name)==location)
        {
            return "Du kannst von hier aus nicht an dein Ziel gehen.";
        }
        else return "Diese Tür ist nicht verschlossen";
    }
}