public class Parser {

    private String adress;
    private String command;

    public void parse(String input)
    {
        command = input.split(" ")[0] != null ? input.split(" ")[0] : input;
        adress = command.length() < input.length() ? input.substring(command.length() + 1) : "";
    }

    public Command createCommand(String input){
        try {
            parse(input);
            return new Command(Commands.valueOf(command.toUpperCase()), adress);
        } catch (Exception e){
            return new Command(Commands.INVALIDINPUT, adress);
        }
    }
}
