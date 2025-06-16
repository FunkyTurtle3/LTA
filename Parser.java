/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Der Parser wird von der Game Engine dafür verwendet eine Eingabe in das Eingabefeld in einen verwendbare Command umzuwandeln.
 * Das heißt einen Command + Argument (2. Teil)
 */
public class Parser {
    /**
     * Diese Methode teilt die Spielereingabe in zwei Teile, sodass diese vom Programm verarbeitet werden können.
     * Diese Methode erstellt außerdem ein Objekt der Command-Klasse und gibt dieses zurück.
     * @author (Leander, Victor, Lasse)
     */
    public static Command createCommand(String input){
        String command;
        String adress = "";
        try {
            command = input.split(" ")[0] != null ? input.split(" ")[0] : input;
            adress = command.length() < input.length() ? input.substring(command.length()).trim() : "";
            return new Command(Commands.valueOf(command.toUpperCase()), adress);
        } catch (Exception e){
            return new Command(Commands.INVALIDINPUT, adress);
        }
    }
}