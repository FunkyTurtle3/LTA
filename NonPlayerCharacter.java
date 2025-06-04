
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