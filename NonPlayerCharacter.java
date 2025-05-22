
/**
 * Beschreiben Sie hier die Klasse NonPlayerCharacter.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NonPlayerCharacter
{
    private String name;
    public static final NonPlayerCharacter EMPTY = new NonPlayerCharacter("");
    public NonPlayerCharacter(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
