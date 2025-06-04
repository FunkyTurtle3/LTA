/**
 * @author (Lasse, Leander)
 * @version (1.1.0)
 * Diese Klasse hat den Zweck dem Parser zu ermöglichen ein Objekt, bestehen aus einem Command und dem 2. Teil der Eingabe, wiederzugeben
 */
public record Command(Commands command, String input) {}