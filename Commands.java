/**
 * @author (Lasse, Leander, Mila, Ella)
 * @version (1.1.0)
 * In dieser Aufzählung sind alle verfügbaren Commands (also das erste Wort einer Eingabe) gespeichert
 */
public enum Commands {
    ZU, //zum Wechseln von Räumen
    NIMM, //zum Aufnehmen von Gegenständen
    LEGE, //zum Ablegen von Gegenständen
    FRAG, //zum Sprechen mit NPCs
    GIB, //zum Übergeben von Gegenständen an NPCs
    STARTE,//zum (Neu-)Starten des Spiels
    INSPIZIERE, //zum Untersuchen eines Gegenstandes
    INFO, //zum Ausgeben einer Spielinfo
    OEFFNE, //zum Aufschliessen einer Tür
    ANTWORTE, //zum Antworten auf das Quiz
    INVALIDINPUT; //zum Ausgeben von ungültigen Eingaben
}