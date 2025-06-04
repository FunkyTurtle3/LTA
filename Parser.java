/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Der Parser wird von der Game Engine dafuer verwendet eine Eingabe in das Eingabefeld in einen verwendbare Command umzuwandeln.
 * Das heißt einen Command + Argument (2. Teil)
 */
public class Parser {

    private String adress;
    private String command;

    /**
     *Diese Methode teilt die Spielereingabe in zwei Teile so dass diese vom programm verabreitet werden können
     */public void parse(String input)
    {
        command = input.split(" ")[0] != null ? input.split(" ")[0] : input;
        adress = command.length() < input.length() ? input.substring(command.length() + 1) : "";
    }

    /**
     * Diese Methode erstellt ein Objekt der Command-Klasse und gibt dieses zurueck
     */public Command createCommand(String input){
        try {
            parse(input);
            return new Command(Commands.valueOf(command.toUpperCase()), adress);
        } catch (Exception e){
            return new Command(Commands.INVALIDINPUT, adress);
        }
    }
}