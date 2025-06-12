import java.util.LinkedList;

/**
 * @author (Lasse, Ella, Mila)
 * @version 1.1.0
 * Ein NPC (Non Player Character (dt. Nicht Spieler Charakter)) wird
 * verwendet, um alle Personen im Spiel abgesehen vom Spieler zu repräsentieren.
 */
public class NonPlayerCharacter
{
    private final String name;
    private final LinkedList<NPCInteraction> interactions;
    private int timesInteracted;
    public static final NonPlayerCharacter EMPTY = new NonPlayerCharacter("");
    public NonPlayerCharacter(String name)
    {
        this.name = name;
        this.interactions = new LinkedList<>();
        this.timesInteracted = 0;
    }

    /**
     * Gibt den Namen des NPCs zurück
     */public String getName()
    {
        return name;
    }

    public NonPlayerCharacter addInteraction(NPCInteraction interaction) {
        if(!interactions.isEmpty() || interaction.input() == Item.EMPTY) {
            interactions.add(interaction);
        }
        return this;
    }

    public NPCInteraction talk(Item input) {
        if (interactions.isEmpty()) return new NPCInteraction("Dieser Charakter kenn leider nicht sprechen!\n", input, input);
        if (input.getName().equalsIgnoreCase(interactions.get(timesInteracted).input().getName())) {
            int i = timesInteracted;
            timesInteracted++;
            return interactions.get(i);
        } else if(timesInteracted != 0) {
            return new NPCInteraction(interactions.get(timesInteracted - 1).outputString(), input, input);
        } else return new NPCInteraction("Wie kann ich dir weiterhelfen?", input, input);
    }
}