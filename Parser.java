public class Parser {
    private String input;
    private String adress;
    private String command;
    public Parser()
    {

    }

    public void parse(String input)
    {
        input.toLowerCase();
        //int space = input.indexOf(' ');
        command = input.split(" ")[0];
        adress = input.split(" ")[1];
    }

    public Command createCommand(String input){
        parse(input);
        try{
            return Command.valueOf(command.toUpperCase());
        }catch(){
            return Command.INVALIDINPUT;

        }

    }


}
