
/**
 * In der Map (dt. Karte) sind alle Räume des Leibniz-Gymnasiums gespeichert. Sie werden in der Kartenerstellung kreiert.
 * @author (Lasse, Leander, Mila, Ella)
 * @version (1.1.0)
 */
public class Map
{
    public final Location START_ROOM;
    public final Location AULA;
    public final Location SCHULHOF;
    public final Location CAFETERIA;
    public final Location TERRASSE;
    public final Location SERDGESCHOSS;
    public final Location S01;
    public final Location S02;
    public final Location S03;
    public final Location S04;
    public final Location S05;
    public final Location KUK;
    public final Location SOG1;
    public final Location S11;
    public final Location S12;
    public final Location S13;
    public final Location S14;
    public final Location S15;
    public final Location S16;
    public final Location SOG2;
    public final Location S21;
    public final Location S22;
    //public final Location S23;
    //public final Location S24;
    public final Location S25;
    public final Location S26;
    public final Location S27;
    public final Location S29;
    public final Location NERDGESCHOSS;
    public final Location N01;
    public final Location N02;
    public final Location N03;
    public final Location N04;
    public final Location N05;
    public final Location NOG1;
    public final Location N11;
    public final Location N12;
    public final Location N13;
    public final Location N14;
    public final Location N15;
    public final Location N16;
    public final Location NOG2;
    public final Location N21;
    public final Location N22;
    public final Location N23;
    public final Location N24;
    public final Location N25;
    public final Location N26;
    public final Location NEUBAU;
    public final Location NB101;
    public final Location NB102;
    public final Location NB103;
    public final Location NB201;
    public final Location NB202;
    public final Location NB203;
    public final Location NB301;
    public final Location NB302;
    /**
     * Konstruktor zum Erstellen einer Karte zu Spielbeginn
     * @author (Mila, Ella, Lasse, Leander)
     */
    public Map() {
        START_ROOM = new Location(
                "Start_Room",
                NonPlayerCharacter.EMPTY,
                "");

        AULA = new Location(
                "Aula",
                new NonPlayerCharacter("Frau Thies")
                        .addInteraction(new NPCInteraction("Möchtest du das Quiz starten?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Dann bring mir das goldene Ticket!", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Los gehts!", new Item("Goldenes Ticket", "Das goldene Ticket ermöglicht dir das Quiz zu starten!"), Item.EMPTY)),
                "Du befindest dich in der Aula");

        SCHULHOF = new Location(
                "Schulhof",
                new NonPlayerCharacter("Herr Alik"),
                "Alles grün hier");

        CAFETERIA = new Location(
                "Cafeteria",
                new NonPlayerCharacter("Ablas Schwester oder so"),
                "Schade dass Abla weg ist");

        TERRASSE = new Location(
                "Terrasse",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich auf der Terrasse.");

        SERDGESCHOSS = new Location(
                "Erdgeschoss-Süd",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im Erdgeschoss des Südflügels.");

        S01 = new Location(
                "S01",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S01.");

        S02 = new Location(
                "S02",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S02.");

        S03 = new Location(
                "S03",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S03.");

        S04 = new Location(
                "S04",
                new NonPlayerCharacter("Linnea")
                        .addInteraction(new NPCInteraction("Brauchst du Hilfe mit dem Quiz in der Aula?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Gegen einen klitzekleinen Gefallen geb ich dir einen Tipp", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Bring mir einen Kuchen und ich verspreche dir du bekommst was du brauchst", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Hier hast du den Schlüssel zum Lehrerzimmer (N03). Dort liegen alle Lösungen parat", new Item("Apfelkuchen"), new Item("Schlüssel zum Lehrerzimmer", "mit diesem Schlüssel gelangst du ins Lehrerzimmer (N03), aber sei vorsichtig!"))),
                "Du befindest dich in Raum S04.");

        S05 = new Location(
                "S05",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S05.");

        KUK = new Location(
                "Kunstkeller",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich im Kunstkeller.");

        SOG1 = new Location(
                "1.Stock-Süd",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im 1.Stock des Südflügels.");

        S11 = new Location(
                "S11",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S11.");

        S12 = new Location(
                "S12",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S12.");

        S13 = new Location(
                "S13",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S13.");

        S14 = new Location(
                "S14",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S14.");

        S15 = new Location(
                "S15",
                new NonPlayerCharacter("Herr M. Müller"),
                "Du befindest dich in Raum S15.");

        S16 = new Location(
                "S16",
                new NonPlayerCharacter("Frau Küchler")
                        .addInteraction(new NPCInteraction("Ich hab gehört du möchtest wissen wie der Architekt unseres Hauses heißt?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du 2 Aufgabe für mich erledigst, dann verrate ich dir den Vornamen.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Bringe mir zunächst die Farbe mit der man zusätzlich zu Blau, Grün mischen kann", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Super! Jetzt besorg mir doch bitte eine Farbe, die eigentlich gar keine ist.", new Item("Gelbe Farbtube"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Perfekt! Der Architekt unseres Gebäudes hieß mit Vornamen Ludwig", new Item("Schwarze Farbtube"), Item.EMPTY)),
                "Du befindest dich in Raum S16.");
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S16.\n" +
                        "Das ist einer der Kunsträume in dem gemalt, gezeichnet\n" +
                        "oder gebastelt wird.");

        SOG2 = new Location(
                "2.Stock-Süd",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im 2.Stock des Südflügels.");


        S21 = new Location(
                "S21",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S21.");

        S22 = new Location(
                "S22",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S22.");

        S23 = new Location(
                "S23",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S23.");

        S24 = new Location(
                "S24",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S24.");

        S25 = new Location(
                "S25",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S25.");

        S26 = new Location(
                "S26",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S26.");

        S27 = new Location(
                "S27",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S27.");


        S29 = new Location(
                "S29",
                new NonPlayerCharacter("Frau Gruhl")
                        .addInteraction(new NPCInteraction("Du kommst wegen des Quiz's richtig?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du mir kurz hilfst, sag ich dir wie der Architekt unseres Hauses mit Nachnamen hieß.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Hol als erstes die Komplementärfarbe von Orange", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Dankeschön! Jetzt brauche ich noch die Farbe für die das \"R\" im RGB-Farbsystem steht", new Item("Blaue Farbtube"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Toll! Der Nachname des Architekten lautet Hoffmann", new Item("Rote Farbtube"), Item.EMPTY)),
                "Du befindest dich in Raum S29.");
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S29.\n" +
                        "Dieser Raum ist dient dem Kunstunterricht und wird\n" +
                        "durch große Fenster mit Licht geflutet.");

        NERDGESCHOSS = new Location(
                "Erdgeschoss-Nord",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im Erdgeschoss des Nordflügels.");

        N01 = new Location(
                "N01",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N01.",
                new Item("Schlüssel"));

        N02 = new Location(
                "N02",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N02.",
                new Item("Schlüssel"));

        N03 = new Location(
                "N03",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N03.",
                new Item("Schlüssel zum Lehrerzimmer"));

        N04 = new Location(
                "N04",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N04.",
                new Item("Schlüssel"));

        N05 = new Location(
                "N05",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N05.",
                new Item("Schlüssel"));

        NOG1 = new Location(
                "1.Stock-Nord",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im 1.Stock des Nordflügel.");

        N11 = new Location(
                "N11",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N11.");

        N12 = new Location(
                "N12",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N12.");

        N13 = new Location(
                "N13",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N13.");

        N14 = new Location(
                "N14",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N14.");

        N15 = new Location(
                "N15",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N15.");

        N16 = new Location(
                "N16",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N16.");

        NOG2 = new Location(
                "2.Stock-Nord",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich nun im 2.Stock des Nordflügels.");
        N21 = new Location(
                "N21",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N21.");

        N22 = new Location(
                "N22",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N22.");

        N23 = new Location(
                "N23",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N23.");

        N24 = new Location(
                "N24",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N24.");

        N25 = new Location(
                "N25",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N25.");

        N26 = new Location(
                "N26",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N26.");

        NEUBAU = new Location(
                "Neubau",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich im Neubau.");

        NB101 = new Location(
                "101",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum 101.");

        NB102 = new Location(
                "102",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum 102.");

        NB103 = new Location(
                "103",
                new NonPlayerCharacter("Herr Türkan")
                        .addInteraction(new NPCInteraction("Du möchtest wissen auf welchen Koordinaten sich das Leibniz-Gymnasium befindet?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("In 202 steht glaube ich ein alter Globus.\nGegen einen kleinen Gefallen könnte ich dir den Schlüssel überlassen.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du mir aus 102 den Stapel Atlanten bringst, dann könntest du ihn bekommen", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Vielen Dank! Hier ist wie versprochen der Schlüssel", new Item("Stapel Atlanten"), new Item("Schlüssel zu 202", "Mit diesem Schlüssel kannst du den Raum 202 aufschließen.\n"))),
                "Du befindest dich in Raum 103.");

        NB201 = new Location(
                "201",
                new NonPlayerCharacter("Frau Krauß")
                        .addInteraction(new NPCInteraction("Du möchtest wissen auf welchem Breitengrad sich das Leibniz-Gymnasium befindet?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Der Breitengrad des Leibniz-Gymnasiums beträgt 52°. Ob Nord oder Süd musst du selbst herausfinden.\nVielleicht findest du ja irgendwo einen Globus.", Item.EMPTY, Item.EMPTY)),
                "Du befindest dich in Raum 201.");

        NB202 = new Location(
                "202",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum 202.",
                new Item("Schlüssel zu 202"));

        NB203 = new Location(
                "203",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum 203.");

        NB301 = new Location(
                "301",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum 301.");

        NB302 = new Location(
                "302",
                new NonPlayerCharacter("Herr Heickmann")
                        .addInteraction(new NPCInteraction("Du möchtest wissen auf welchem Längengrad sich das Leibniz-Gymnasium befindet?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Der Längengrad des Leibniz-Gymnasiums beträgt 13°. Ob Ost oder West musst du selbst herausfinden.\nVielleicht findest du ja irgendwo einen Globus.", Item.EMPTY, Item.EMPTY)),
                "Du befindest dich in Raum 302.");

        START_ROOM.addPassage(AULA);
        AULA.addPassage(SCHULHOF).addPassage(CAFETERIA);
        SCHULHOF.addPassage(AULA).addPassage(SERDGESCHOSS).addPassage(NERDGESCHOSS);
        TERRASSE.addPassage(SOG1).addPassage(NOG1);
        CAFETERIA.addPassage(AULA);
        S01.addPassage(SERDGESCHOSS);
        S02.addPassage(SERDGESCHOSS);
        S03.addPassage(SERDGESCHOSS);
        S04.addPassage(SERDGESCHOSS);
        S05.addPassage(SERDGESCHOSS);
        KUK.addPassage(SERDGESCHOSS);
        SERDGESCHOSS.addPassage(S01).addPassage(S02).addPassage(S03).addPassage(S04).addPassage(S05).addPassage(KUK).addPassage(SCHULHOF).addPassage(SOG1);
        S11.addPassage(SOG1);
        S12.addPassage(SOG1);
        S13.addPassage(SOG1);
        S14.addPassage(SOG1);
        S15.addPassage(SOG1);
        S16.addPassage(SOG1);
        SOG1.addPassage(S11).addPassage(S12).addPassage(S13).addPassage(S14).addPassage(S15).addPassage(S16).addPassage(SERDGESCHOSS).addPassage(SOG2).addPassage(TERRASSE);
        S21.addPassage(SOG2);
        S22.addPassage(SOG2);
        S23.addPassage(SOG2);
        S24.addPassage(SOG2);
        S25.addPassage(SOG2);
        S26.addPassage(SOG2);
        S27.addPassage(SOG2);
        S29.addPassage(SOG2);
        SOG2.addPassage(S21).addPassage(S22).addPassage(S23).addPassage(S24).addPassage(S25).addPassage(S26).addPassage(S27).addPassage(S29).addPassage(SOG1);
        N01.addPassage(NERDGESCHOSS);
        N02.addPassage(NERDGESCHOSS);
        N03.addPassage(NERDGESCHOSS);
        N04.addPassage(NERDGESCHOSS);
        N05.addPassage(NERDGESCHOSS);
        NERDGESCHOSS.addPassage(N01).addPassage(N02).addPassage(N03).addPassage(N04).addPassage(N05).addPassage(SCHULHOF).addPassage(NOG1);
        N11.addPassage(NOG1);
        N12.addPassage(NOG1);
        N13.addPassage(NOG1);
        N14.addPassage(NOG1);
        N15.addPassage(NOG1);
        N16.addPassage(NOG1);
        NOG1.addPassage(N11).addPassage(N12).addPassage(N13).addPassage(N14).addPassage(N15).addPassage(N16).addPassage(NERDGESCHOSS).addPassage(NOG2).addPassage(NEUBAU).addPassage(TERRASSE);
        N21.addPassage(NOG2);
        N22.addPassage(NOG2);
        N23.addPassage(NOG2);
        N24.addPassage(NOG2);
        N25.addPassage(NOG2);
        N26.addPassage(NOG2);
        NOG2.addPassage(N21).addPassage(N22).addPassage(N23).addPassage(N24).addPassage(N25).addPassage(N26).addPassage(NOG1).addPassage(NEUBAU);
        NEUBAU.addPassage(NB101).addPassage(NB102).addPassage(NB103).addPassage(NB201).addPassage(NB202).addPassage(NB203).addPassage(NB301).addPassage(NB302).addPassage(NOG1).addPassage(NOG2);
        NB101.addPassage(NEUBAU);
        NB102.addPassage(NEUBAU);
        NB103.addPassage(NEUBAU);
        NB201.addPassage(NEUBAU);
        NB202.addPassage(NEUBAU);
        NB203.addPassage(NEUBAU);
        NB301.addPassage(NEUBAU);
        NB301.addPassage(NEUBAU);

        AULA.addItem(new Item("Capri Sonne", "Dies ist eine erfrischende Capri-Sonne mit Multivitamin Geschmack"));
        SCHULHOF.addItem(new Item("Stein", "Dies ist ein grauer dreckiger Stein."));
        CAFETERIA.addItem(new Item("Goldenes Ticket", "Das goldene Ticket ermöglicht dir das Quiz zu starten!"));
        CAFETERIA.addItem(new Item("Apfelkuchen", "Wer wollte nochmal Kuchen haben?"));
        NERDGESCHOSS.addItem(new Item("Schlüssel", "Mit einem Schlüssel kannst du verschlossene Türen aufschließen"));

        NB102.addItem(new Item("Stapel Atlanten", "Das ist ein Stapel Atlanten. Herr Türkan in 103 sucht genau so einen."));
        NB202.addItem(new Item("Globus", "Auf dem Globus ist ein Roter Punkt. Darüber steht Leibniz-Gymnasium." +
                "\nDer Punkt liegt irgendwo zwischen 50° und 60° N und zwischen 10° und 20° O"));
                
        N03.addItem(new Item("Lösungen", ""));
    }

    public Location getStartLocation() {
        return START_ROOM;
    }
}