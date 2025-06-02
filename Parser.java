public class Parser {

    private String adress;
    private String command;

    public void parse(String input)
    {
        //int space = input.indexOf(' ');
        command = input.split(" ")[0];
        adress = input.split(" ")[1];
        command.toLowerCase();
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
