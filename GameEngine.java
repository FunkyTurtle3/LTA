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
    private final LinkedList<Item> inventory; //Hier sind alle Gegenstände gespeichert, die der Spieler mit sich herumträgt.
    private final NonPlayerCharacter quiz; //Das Quiz gespeichert. Hierfür verwerten wir die funktion von NPCs mit abwandlung zum Antworten
    private Map map; //Attribut für die Karte der Schule
    private Location location; //Zeigt an welchem Ort, sich der Spieler gerade befindet
    private boolean isInDevMode; //Zeigt ob der Spieler sich im Entwicklermodus befindet

    /**
     * Konstruktor der GameEngine Klasse
     * @author (Lasse, Leander, Ella, Mila, Victor)
     */ public GameEngine() {
        this.map = new Map(); //Erstellt eine frische Karte für den Spieler
        this.location = map.getStartLocation(); //Legt die erste Location für den Spieler fest
        this.inventory = new LinkedList<>(); //Erstellt das leere Inventar
        this.quiz = new NonPlayerCharacter("") //Erstellt das Quiz (Ein NPC)
            //.addInteraction(new NPCInteraction("Seit welchem Jahr ist es Schülerinnen erlaubt am Leibniz Gymnasium zu lernen?", Item.EMPTY, Item.EMPTY)) //Geschichte? - not solvable
            .addInteraction(new NPCInteraction("Wie viele Räume hat das Gebäude des Leibniz-Gymnasiums insgesamt?", Item.EMPTY, Item.EMPTY)) //Hausmeister - solvable
            .addInteraction(new NPCInteraction("Wie lautet die Zahl 175 im Binärcode?", new Item("94"), Item.EMPTY)) //Informatik - solvable
            .addInteraction(new NPCInteraction("Nach welcher Person, wurde die Schule vor Gottfried Wilhelm Leibniz benannt?", new Item("10101111"), Item.EMPTY)) //Geschichte - solvable
            .addInteraction(new NPCInteraction("Auf welchen Koordinaten befindet sich das Gebäude des Leibniz-Gymnasium?", new Item("Robert Koch"), Item.EMPTY)) //Geografie - solvable
            .addInteraction(new NPCInteraction("Welchen Namen trug der Architekt des Gebäudes vom Leibniz-Gymnasium?", new Item("52° N, 13° O"), Item.EMPTY)) //Kunst - solvable
            .addInteraction(new NPCInteraction("Wann wurde das Leibniz-Gymnasium erstmals als MINT-freundliche Schule ausgezeichnet?", new Item("Ludwig Hoffmann"), Item.EMPTY)) //Schulleitung - solvable
            .addInteraction(new NPCInteraction("Mit wie viel Prozent der Stimmen gewann die Parte \"Die Linke\" 2025 die Juniorwahl?", new Item("2013"), Item.EMPTY)) //Politik - not solvable
            .addInteraction(new NPCInteraction("Welcher Epoche lässt sich Gottfried Wilhelm Leibniz's Person zuordnen?", new Item("39,8", ""), Item.EMPTY)) //Deutsch - solvable
            .addInteraction(new NPCInteraction("Schreibe die Ordnungszahlen der Chemischen Elemente auf\nmit welchen durch die Anfangsbuchstaben des Elementsymbols das Wort Leibniz gebildet werden kann.\nEs gilt immer die kleinstmögliche Zahl.", new Item("Aufklärung", ""), Item.EMPTY)) //Chemie - solvable
            .addInteraction(new NPCInteraction("Du hast das Quiz erfolgreich bestanden und dir somit das Abitur redlich verdient.\nVielen Dank fürs Spielen, wir hoffen du hattest große Freude.\nWir hatten die auf jeden Fall", new Item("3 63 53 4 7 53 30", ""), Item.EMPTY));
        this.isInDevMode = false;
    }

    /**
     * Führt eingabenspezifische Methoden aus
     * @author (Mila, Ella, Lasse, Leander)
     */public String input(String input) {
        Command command = Parser.createCommand(input.toLowerCase()); //Speichert den input als Command-Objekt ausgegeben vom Parser
        String output = ""; //Legt die output Variable fest (um Fehler zu vermeiden im return Statement)

        switch (command.command()) { //Führt eine zum input passende Methode aus
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

        return "\nDu: " + input + "\n \n" + output + "\n\n"; //Gibt die zugehörige Ausgabe zurück
    }

    /**
     * Wird verwendet, um mit dem Quiz zu interagieren
     * @author (Lasse, Leander)
     */
    public String answerQuiz(String input) {
        if(!this.location.getName().equals("Aula")) { //Fängt den Fall ab, dass der Spieler nicht in der Aula ist
            return "Du musst in der Aula sein um das Quiz zu machen";
        } else if (this.quiz.getTimesInteracted() <= 0) { //Fängt den Fall ab, dass der Spieler das Quiz noch nicht gestartet hat
            return "Benutze den \"Starte Quiz\"-Befehl um das Quiz zu starten";
        } else return quiz.talk(new Item(input, "")).outputString(); //Falls andere Bedingungen erfüllt, wird die Antwort ausgeführt "new Item(input, "")" wird für Funktionsweise benötigt
    }

    /**
     * Methode die, die Spielfunktionen beschreibt, sobald der Spieler sie abfragt
     * @author (Lasse, Victor)
     */
    public String getInfo() {
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
                
                "Frag": um mit Personen zu Sprechen
                Manchmal musst du den Befehl mehrfach hintereinander verwenden,
                um alle Informationen zu bekommen
                
                "Gib <Gegenstand>": um mit Personen zu sprechen\
                
                "Oeffne <Raum>": um eine Tür zu einem Raum zu öffnen\
                
                "Antworte <Antwort>": um eine Frage des Quiz's zu beantworten\
                
                """; //Informationen für Spiel
    }

    /**
     * Methode die es ermöglicht mit NPCs zu kommunizieren
     * @author (Lasse, Victor)
     */
    public String talkToNPC() {
        NonPlayerCharacter nonPlayerCharacter = location.getNPC(); //NPC zwischengespeichert
        NPCInteraction npcInteraction = nonPlayerCharacter.talk(Item.EMPTY); //NPCInteraction zwischengespeichert
        if(npcInteraction.output() != Item.EMPTY) inventory.add(npcInteraction.output()); //Fügt das output-Item (falls vorhanden) zum Inventar hinzu
        return nonPlayerCharacter.getName() + ": " + npcInteraction.outputString(); //Gibt den notwendigen output aus
    }

    /**
     * Methode die es ermöglicht NPCs Gegenstände zu überreichen
     * @author (Lasse, Victor)
     */
    public String giveNPC(String input) {
        Item item = Item.EMPTY; //Legt die item Variable fest
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(input)) {
                item = inventory.remove(i);
            }
        } //Sucht Item mit dem Namen input im Inventar und löscht es, falls gefunden
        NPCInteraction interaction = location.getNPC().talk(item); //Speichert NPCInteraction zwischen
        if (interaction.output() != Item.EMPTY) inventory.add(interaction.output()); //Fügt das output-Item (falls vorhanden) zum Inventar hinzu. Wenn der NPC das Item nicht will, gibt er es automatisch als output wieder zurück
        return location.getNPC().getName() + ": " + interaction.outputString(); //Gibt den notwendigen outputString aus
    }

    /**
     * Methode zum Zurückgeben des Inhalts des Spielerinventars in Form eines Strings
     * @author (Mila, ELla)
     */
    public String getInventoryDescription() {
        StringBuilder des = new StringBuilder(); //Speichert einen StringBuilder, um im Folgenden den String aufzubauen
        for (int i = 0; i < this.inventory.size(); i++) {
            des.append(inventory.get(i).getName()).append("\n"); //Baut den String mit allen Items auf
        }
        return des.toString(); //gibt den String aus
    }

    /**
     * Setzt das Spiel auf den Anfang zurück. Startet das Spiel. Startet das Quiz
     * @author (Lasse Leander)
     */
    public String start(String input) {
        if(input.equalsIgnoreCase("neu")) {
            this.map = new Map(); //Setzt alle Attribut zurück
            this.inventory.clear(); //Setzt alle Attribut zurück
            this.location = map.getStartLocation(); //Setzt alle Attribut zurück
            this.isInDevMode = false; //Setzt alle Attribut zurück
            this.quiz.setTimesInteracted(0); //Setzt alle Attribut zurück
            return "";
        } else if(input.equalsIgnoreCase("spiel") && this.location.getName().equals("Start_Room")) {
            return toLocation("Aula"); //Startet das Spiel, indem der Spieler zur Aula geht
        } else if(input.equalsIgnoreCase("quiz") && this.location.getName().equals("Aula") && quiz.getTimesInteracted() == 0) {
            return quiz.talk(Item.EMPTY).outputString(); //Startet das Spiel, indem es mit dem NPC redet
        } else return "Gebe \"Starte neu/Spiel/Quiz\" ein "; //Default Ausgabe, falls keine der Bedingungen erfüllt
    }

    /**
     * Diese Methode versucht einen Gegenstand aus einem Raum/Ort in das Inventar zu platzieren
     * @author (Lasse, Leander)
     */
    public String takeItem(String name) {
        Item item = location.takeItem(name); //Speichert das gefundene Item zwischen
        if(item.getName().equals("Beutel voller Termit") && !isInDevMode) System.exit(0); //Easter-Egg ausgeführt, falls der Spieler sich anmaßt das Termit aufheben zu können
        if(item != Item.EMPTY) {
            inventory.addLast(item); //Fügt das Item zum Inventar hinzu, falls vorhanden
            return "Ok!\n\n" + location.getDescription(); //Gibt den output aus
        } else return "Da ist kein solcher Gegenstand!"; //Wird gezeigt, falls Item nicht vorhanden
    }

    /**
     * Diese Methode versucht den Spieler in einen anliegenden Raum/Ort zu bewegen
     * @author (Mila, Ella, Lasse, Leander)
     */
    public String toLocation(String name) {
        if (isInDevMode) {
            try {
                Field feld = this.map.getClass().getField(name.toUpperCase());  //Sucht nur public Felder deshalb "public final verwendet" Field-Klasse vorgeschlagen von ChatGPT
                Object wert = feld.get(map); //Methode von ChatGPT ausgegeben
                this.location = (Location) wert; //Ändert Location zum gefundenen Wert
                return location.getDescription(); //Gibt den output aus
            } catch (Exception e) {
                System.out.println("Location '" + name + "' existiert nicht oder ist nicht public."); //Wird ausgeführt, falls Location nicht gefunden
            }
        } //Hilfe durch https://chatgpt.com
        Location location = this.location.hasPassageTo(name); //Falls nicht im DevMode oder Loc nicht gefunden zwischengespeichert
        if(location != null) { //Prüft, ob Durchgang möglich
            if(!location.isLocked()) { //Prüft ob Tür verschlossen
                this.location = location; //Wechselt Location
                return location.getDescription(); // Gibt die Beschreibung aus
            } else return "Der Raum ist verschlossen!"; //Falls Raum verschlossen
        } else return "Das geht leider nicht!"; //Falls Durchgang nicht vorhanden
    }

    /**
     * Versucht einen Gegenstand aus dem Inventar des Spielers in den Raum/Ort zu platzieren
     * @author (Lasse, Leander)
     */
    public String dropItem(String name) {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name)) { //Sucht nach Item im Inventar
                location.addItem(inventory.remove(i)); //Löscht Item aus Inv und gibt es der Location
                return "Ok!\n\n" + location.getDescription();
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!"; //Falls Gegenstand nicht im Inventar
    }

    /**
     * Gibt eine Beschreibung eines bestimmten Gegenstandes zurück.
     * @author (Mila, Ella)
     */
    public String getItemDescription(String name)
    {
        for(int i = 0; i < inventory.size(); i++) {
            if(inventory.get(i).getName().equalsIgnoreCase(name)) { //Sucht nach Item im Inventar
                return inventory.get(i).getDescription(); //Gibt Beschreibung des Items zurück
            }
        }
        return "Du hast keinen solchen Gegenstand in deinem Inventar!"; //Falls Gegenstand nicht im Inventar
    }

    /**
     * Versucht verschlossene Türen zu öffnen, wenn der Spieler einen Schlüssel hat.
     * @author (Mila, Ella, Lasse)
     */
    public String openDoor(String name)
    {
        Location target = location.hasPassageTo(name); //Speichert Ziel-Location zwischen
        if(target == null) return "Du kannst von hier aus nicht an dein Ziel gehen."; //Wird ausgeführt falls Durchgang nicht vorhanden
        else if(target.isLocked()) { //Prüft, ob Durchgang überhaupt verschlossen ist
            for(int i = 0; i < inventory.size(); i++) {
                if(inventory.get(i).getName().equalsIgnoreCase(target.getUnlockItem().getName())) { //Sucht nach notwendigem Schlüssel im Inventar
                    target.open(); //Wenn gefunden wird Durchgang geöffnet
                    return "Die Tür ist jetzt geöffnet.";
                }
            } return "Du hast keinen Schlüssel."; //Falls Schlüssel nicht vorhanden
        } else return "Diese Tür ist nicht verschlossen"; //Falls Tür nicht verschlossen
    }
}