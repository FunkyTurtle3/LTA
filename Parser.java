/**
 * @author (Lasse, Leander, Victor)
 * @version 1.1.0
 * Der Parser wird von der Game Engine dafür verwendet eine Eingabe aus dem Eingabefeld in ein Obejekt umzuwandeln.
 * Dieses Objekt wird dann genutzt um Eingabe spezifische Methoden aufzurufen.
 * Das Objekt ist ein Command-Objekt welches eine Enum und einen String speichert.
 */
public class Parser {
    /**
     * Diese Methode teilt die Spielereingabe so auf das ein entsprechendes Command-Objekt erstellt werden kann.
     * Dieses Command-Objekt wird der GameEngine zurückgegeben um verarbeitet zu werden.
     * @author (Leander, Victor, Lasse)
     */
    public static Command createCommand(String input){
        String command;
        String adress = "";
        try {
            if(input.split(" ")[0] != null) {
                command = input.split(" ")[0];
            } else command = input;

            if (command.length() < input.length()) {
                adress = input.substring(command.length()).trim();
            } else adress = "";
            return new Command(Commands.valueOf(command.toUpperCase()), adress);
        } catch (Exception e){
            return new Command(Commands.INVALIDINPUT, adress);
        }
    }
}