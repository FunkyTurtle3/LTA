/**
 * @author (Lasse, Leander)
 * @version (1.1.0)
 * In dieser Aufzählung sind alle verfügbaren Commands (also das erste Wort einer Eingabe) gespeichert
 */
public enum Commands {
    ZU, //Zum Wechseln von Räumen
    NIMM, //Zum Aufnehmen von Gegenständen
    LEGE, //Zum Ablegen von Gegenständen
    SPRICH, //Zum Sprechen mit NPCs
    GIB, //Zum Übergeben von Gegenständen an NPCs
    INVALIDINPUT, //Zum Ausgeben von ungültigen Eingaben
    STARTE, //Zum (Neu-)Starten des Spiels
    INFO; //Zum Ausgeben einer Spielinfo
}