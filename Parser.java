/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Der Parser wird von der Game Engine dafür verwendet eine Eingabe in das Eingabefeld in einen verwendbare Command umzuwandeln.
 * Das heißt einen Command + Argument (2. Teil)
 */
public class Parser {

    private String adress;
    private String command;

    /**
     * Diese Methode teilt die Spielereingabe in zwei Teile, sodass diese vom Programm verarbeitet werden können
     * @author (Leander, Victor, Lasse)
     */public void parse(String input)
    {
        command = input.split(" ")[0] != null ? input.split(" ")[0] : input;
        adress = command.length() < input.length() ? input.substring(command.length()).trim() : "";
    }

    /**
     * Diese Methode erstellt ein Objekt der Command-Klasse und gibt dieses zurück
     * @author (Leander, Victor, Lasse)
     */public Command createCommand(String input){
        try {
            parse(input);
            return new Command(Commands.valueOf(command.toUpperCase()), adress);
        } catch (Exception e){
            return new Command(Commands.INVALIDINPUT, adress);
        }
    }
}