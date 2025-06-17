
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
                new NonPlayerCharacter("Herr Alik")
                        .addInteraction(new NPCInteraction("Wenn du mir den Besen aus dem südlichen Erdgeschoss bringst,\ndann erzähle ich dir wie viele Räume wir haben.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("""
                                In unserem Gebäude befinden sich an Räumen:
                                15 im Nordflügel
                                17 im Südflügel
                                6 im Neubau
                                5 Treppenhäuser
                                6 Flure
                                3 Kunsträume\s
                                3 Musikräume
                                2 Räume bei Sekretariat
                                3 Räume bei Aula\s
                                12 Toilettenräume
                                4 Besenkammern
                                16 im Kellergewölbe mit Holzwerkstatt
                                2 Vorräume""", new Item("Besen"), Item.EMPTY)),
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
                new NonPlayerCharacter("Frau Pilin")
                        .addInteraction(new NPCInteraction("Brauchst du Hilfe beim herausfinden der Epoche, welcher G.F. Leibniz zuzuordnen ist?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Ein kleiner Tipp, der Zeitraum der Epoche liegt zwischen 1500 n. Chr. und  1765 n. Chr.", Item.EMPTY, Item.EMPTY)),
                "Du befindest dich in Raum S02.");

        S03 = new Location(
                "S03",
                new NonPlayerCharacter("Herr Herold")
                        .addInteraction(new NPCInteraction("ZUM MEPHISTO!!! Bist du nicht hier um die Epoche von G.F. Leibniz zu erfahren?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Ein kleiner Tipp, der Name enthält einen Umlaut (ä/ö/ü).", Item.EMPTY, Item.EMPTY)),

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
                new NonPlayerCharacter("Herr Müller") //M. Entfernt da nur einer von beiden im Spiel
                        .addInteraction(new NPCInteraction("Du kommst sicherlich wegen des Quiz's, oder?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du mir eine Lochkarte von Herrn Meinecke geben kannst, dann helfe ich dir weiter.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Vielen Dank. Hier ist der Schlüssel zu S25, dass ist unser Serverraum.\nDort findest du eine SSD auf der die Zahl 175 im Binärcode steht.\nVielleicht hilf Herr Kempf in N25 dir sie einzulesen.", new Item("Lochkarte"), new Item("Schlüssel für S25", "Mit diesem Schlüssel kannst du den Serverraum N25 aufschließen."))),
                "Du befindest dich in Raum S15.");

        S16 = new Location(
                "S16",
                new NonPlayerCharacter("Frau Küchler")
                        .addInteraction(new NPCInteraction("Ich hab gehört du möchtest wissen wie der Architekt unseres Hauses heißt?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du 2 Aufgabe für mich erledigst, dann verrate ich dir den Vornamen.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Bringe mir zunächst die Farbe mit der man zusätzlich zu Blau, Grün mischen kann", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Super! Jetzt besorg mir doch bitte eine Farbe, die eigentlich gar keine ist.", new Item("Gelbe Farbtube"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Perfekt! Der Architekt unseres Gebäudes hieß mit Vornamen Ludwig", new Item("Schwarze Farbtube"), Item.EMPTY)),
                """
                        Du befindest dich in Raum S16.
                        Das ist einer der Kunsträume in dem gemalt, gezeichnet
                        oder gebastelt wird.""");


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

        //S23 = new Location(
        //        "S23",
        //        NonPlayerCharacter.EMPTY,
        //        "Du befindest dich in Raum S23.");

        //S24 = new Location(
        //        "S24",
        //        NonPlayerCharacter.EMPTY,
        //        "Du befindest dich in Raum S24.");
        //Existenzkrise

        S25 = new Location(
                "S25",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S25.",
                new Item("Schlüssel zu S25"));

        S26 = new Location(
                "S26",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum S26.\n" +
                        "Hier ist ein kleiner Informatikraum. Normalerweise findet hier die Robotik AG statt",
                new Item("Schlüssel zu S26"));

        S27 = new Location(
                "S27",
                new NonPlayerCharacter("Herr Meinecke")
                        .addInteraction(new NPCInteraction("Du willst wissen wie die Zahl 175 im Binärcode aussieht?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Dann bring mir doch bitte eine Floppy Disk, da müsste mindestens die Hälfte drinstehen", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Perfekt, hier hast du eine Lochkarte, da habe ich die Hälfte reingeschrieben.\nBring Diese zu Herrn Müller in S15, der kann dir weiterhelfen.", new Item("Floppy Disk"), new Item("Lochkarte", "Geradezu antik das Teil.\nHerr Müller wollte so eine haben."))),
                "Du befindest dich in Raum S27.");


        S29 = new Location(
                "S29",
                new NonPlayerCharacter("Frau Gruhl")
                        .addInteraction(new NPCInteraction("Du kommst wegen des Quiz's richtig?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du mir kurz hilfst, sag ich dir wie der Architekt unseres Hauses mit Nachnamen hieß.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Hol als erstes die Komplementärfarbe von Orange", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Dankeschön! Jetzt brauche ich noch die Farbe für die das \"R\" im RGB-Farbsystem steht", new Item("Blaue Farbtube"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Toll! Der Nachname des Architekten lautet Hoffmann", new Item("Rote Farbtube"), Item.EMPTY)),
                """
                        Du befindest dich in Raum S29.
                        Dieser Raum dient dem Kunstunterricht und wird
                        durch große Fenster mit Licht geflutet.""");

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
                "Du befindest dich in Raum N13.\nHier werden gefährliche Stoffe für den Chemieunterricht aufgehoben.\nFASSE AUF GAR KEINEN FALL DAS TERMIT AN!!!",
                new Item("Schlüssel für N13"));

        N14 = new Location(
                "N14",
                new NonPlayerCharacter("Herr Vogler")
                        .addInteraction(new NPCInteraction("Brauchst du die Lösung für die Chemieaufgabe aus dem Quiz?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Wenn du Herrn Godowski die Utensilien aus N13 bringst, dann hilft er dir bestimmt.\nHier hast du eine Liste.\nIch glaube aber du brauchst noch einen Schlüssel", Item.EMPTY, new Item("Liste mit Chemieutensilien:\nKupfer\nZink\nBunsenbrenner")))
                        .addInteraction(new NPCInteraction("Hier hast du den Schlüssel.\nSei aber bloß vorsichtig und lass die Finger von dem Termit", Item.EMPTY, new Item("Schlüssel zu N13", "Öffne N13 mit diesem Schlüssel"))),
                "Du befindest dich in Raum N14.");

        N15 = new Location(
                "N15",
                new NonPlayerCharacter("Herr Godowski")
                        .addInteraction(new NPCInteraction("Gib mir zuerst den Bunsenbrenner", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Und jetzt das Kupfer", new Item("Bunsenbrenner"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Als letztes das Zink", new Item("Kupferklumpen"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Toll! Jetzt kann ich Messing in meinem Unterricht herstellen. Hier hast du die Lösung.", new Item("Behälter mit Zinkpulver"), new Item("Zettel mit Lösung", """
                                Lösung:
                                
                                Lithium (L) mit 3
                                Europium (E) mit 63
                                Iod (I) mit 53
                                Beryllium (B) mit 4
                                Stickstoff (N) mit 7
                                Iod (I) mit 53
                                Zink (Z) mit 30
                                
                                3 63 53 4 7 53 30"""))),
                "Du befindest dich in Raum N15.");

        N16 = new Location(
                "N16",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N16.\n" +
                        "Hier stehen viele Instrumente.");

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
                new NonPlayerCharacter("Herr Kempf")
                        .addInteraction(new NPCInteraction("Hast du mir die SSD aus dem Serverraum mitgebracht?\nWenn ja, dann helfe ich dir die Zahl 175 im Binärcode auszulesen.", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Das brauchte ich. Dann lass uns mal gucken.\n Ich lasse die SSD jetzt auslesen.", new Item("SSD"), Item.EMPTY))
                        .addInteraction(new NPCInteraction("Die Zahl im Binärcode lautet 10101111. Ich hoffe ich konnte dir weiterhelfen.", Item.EMPTY, Item.EMPTY)),
                "Du befindest dich in Raum N25.");

        N26 = new Location(
                "N26",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich in Raum N26.");

        NEUBAU = new Location(
                "Neubau",
                NonPlayerCharacter.EMPTY,
                "Du befindest dich im Neubau.\n" +
                        "Hier ist es oft zu heiß.");

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
        //S23.addPassage(SOG2);
        //S24.addPassage(SOG2);
        S25.addPassage(SOG2);
        S26.addPassage(SOG2);
        S27.addPassage(SOG2);
        S29.addPassage(SOG2);
        SOG2.addPassage(S21).addPassage(S22).addPassage(S25).addPassage(S26).addPassage(S27).addPassage(S29).addPassage(SOG1);//.addPassage(S23).addPassage(S24)
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
                "\nDer Punkt liegt irgendwo zwischen 50° und 60° N und zwischen 10° und 20° O."));
                
        N03.addItem(new Item("Lösungen", ""));

        //Items in den Kunst-Räumen
        KUK.addItem(new Item("Blaue Farbtube", "Das ist eine blaue Farbtube. Acryl ist da glaube ich drin."));
        KUK.addItem(new Item("Schwarze Farbtube", "Das ist ein Plastikbehälter mit schwarzer Farbe. Latex ist da vielleicht drin."));
        S16.addItem(new Item("Rote Farbtube", "Das ist eine Tube mit roter Farbe. Pigment ist da vermutlich drin."));
        S29.addItem(new Item("Gelbe Farbtube", "Das ist eine gelbe Tube voller Farbe. Öl ist da eventuell drin."));

        //Items für die Informatikfrage
        S25.addItem(new Item("SSD", "Bring dieses Solid-State Drive zu Herrn Kempf in N15"));
        S15.addItem(new Item("Floppy Disk", "Ein bisschen veraltet die Technik.\nHerr Meinecke sucht genau so eine für seine Robotik AG."));

        //Items für die Hausmeisterfrage
        SERDGESCHOSS.addItem(new Item("Besen", "Du weißt aber was man mit einem Besen macht oder?"));

        //Items für die Chemiefrage
        N13.addItem(new Item("Behälter mit Zinkpulver", "Naja, wie der Name sagt, da ist Zinkpulver drin."));
        N13.addItem(new Item("Kupferklumpen", "Ist halt ein Klumpen aus Kupfer."));
        N13.addItem(new Item("Beutel voller Termit", "Wenn du das hier lesen kannst, dann bist du am schummeln!"));
        N13.addItem(new Item("Wasserflasche", "Was soll ich sagen?"));
        N13.addItem(new Item("Bunsenbrenner", "Vorsicht heiß!"));
        N13.addItem(new Item("Packung mit Magnesiastäbchen", "Stäbchen aus Magnesiumoxid..."));

        //Items für die Deutschfrage
        S01.addItem(new Item("Arbeitsblatt mit Zeitstrahl", """
                
                Mittelalter          860 – 1500
                Barock          1600 – 1720
                Aufklärung          1720 – 1800
                Empfindsamkeit          1740 – 1790
                Sturm und Drang          1765 – 1790
                Weimarer Klassik          1786 – 1832
                Romantik          1795 – 1840
                Vormärz          1815 – 1848
                Biedermeier          1815 – 1848
                Realismus          1848 – 1890
                Naturalismus          1880 – 1900"""));
    }

    public Location getStartLocation() {
        return START_ROOM;
    }
}