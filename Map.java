import java.util.LinkedList;

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
    public final Location S23;
    public final Location S24;
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
     * Konstruktor zum erstellen einer Karte zu Spielbeginn
     * @author(Mila, Ella)
     */
    public Map() {
        START_ROOM = new Location(
                "Start_Room",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "",
                false);

        AULA = new Location(
                "Aula",
                new NonPlayerCharacter("Frau Thies")
                        .addInteraction(new NPCInteraction("Möchtest du das Quiz starten?", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Dann bring mir das goldene Ticket!", Item.EMPTY, Item.EMPTY))
                        .addInteraction(new NPCInteraction("Los gehts!", new Item("Goldenes Ticket", "Das goldene Ticket ermöglicht dir das Quiz zu starten!"), Item.EMPTY)),
                new LinkedList<>(),
                "Du befindest dich in der Aula",
                false);

        SCHULHOF = new Location(
                "Schulhof",
                new NonPlayerCharacter("Herr Alik"),
                new LinkedList<>(),
                "Alles grün hier",
                false);

        CAFETERIA = new Location(
                "Cafeteria",
                new NonPlayerCharacter("Ablas Schwester oder so"),
                new LinkedList<>(),
                "Schade dass Abla weg ist",
                false);

        TERRASSE = new Location(
                "Terrasse",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich auf der Terrasse.",
                false);

        SERDGESCHOSS = new Location(
                "Erdgeschoss-Süd",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im Erdgeschoss des Südflügels.",
                false);

        S01 = new Location(
                "S01",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S01.",
                false);

        S02 = new Location(
                "S02",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S02.",
                false);

        S03 = new Location(
                "S03",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S03.",
                false);

        S04 = new Location(
                "S04",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S04.",
                false);

        S05 = new Location(
                "S05",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S05.",
                false);

        KUK = new Location(
                "Kunstkeller",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich im Kunstkeller.",
                false);

        SOG1 = new Location(
                "1.Stock-Süd",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im 1.Stock des Südflügels.",
                false);

        S11 = new Location(
                "S11",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S11.",
                false);

        S12 = new Location(
                "S12",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S12.",
                false);

        S13 = new Location(
                "S13",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S13.",
                false);

        S14 = new Location(
                "S14",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S14.",
                false);

        S15 = new Location(
                "S15",
                new NonPlayerCharacter("Herr M. Müller"),
                new LinkedList<>(),
                "Du befindest dich in Raum S15.",
                false);

        S16 = new Location(
                "S16",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S16.",
                false);

        SOG2 = new Location(
                "2.Stock-Süd",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im 2.Stock des Südflügels.",
                false);


        S21 = new Location(
                "S21",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S21.",
                false);

        S22 = new Location(
                "S22",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S22.",
                false);

        S23 = new Location(
                "S23",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S23.",
                false);

        S24 = new Location(
                "S24",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S24.",
                false);

        S25 = new Location(
                "S25",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S25.",
                false);

        S26 = new Location(
                "S26",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S26.",
                false);

        S27 = new Location(
                "S27",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S27.",
                false);


        S29 = new Location(
                "S29",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum S29.",
                false);

        NERDGESCHOSS = new Location(
                "Erdgeschoss-Nord",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im Erdgeschoss des Nordflügels.",
                false);

        N01 = new Location(
                "N01",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N01.",
                true);

        N02 = new Location(
                "N02",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N02.",
                true);

        N03 = new Location(
                "N03",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N03.",
                true);

        N04 = new Location(
                "N04",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N04.",
                true);

        N05 = new Location(
                "N05",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N05.",
                true);

        NOG1 = new Location(
                "1.Stock-Nord",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im 1.Stock des Nordflügel.",
                false);

        N11 = new Location(
                "N11",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N11.",
                false);

        N12 = new Location(
                "N12",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N12.",
                false);

        N13 = new Location(
                "N13",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N13.",
                false);

        N14 = new Location(
                "N14",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N14.",
                false);

        N15 = new Location(
                "N15",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N15.",
                false);

        N16 = new Location(
                "N16",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N16.",
                false);

        NOG2 = new Location(
                "2.Stock-Nord",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich nun im 2.Stock des Nordflügels.",
                false);


        N21 = new Location(
                "N21",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N21.",
                false);

        N22 = new Location(
                "N22",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N22.",
                false);

        N23 = new Location(
                "N23",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N23.",
                false);

        N24 = new Location(
                "N24",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N24.",
                false);

        N25 = new Location(
                "N25",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N25.",
                false);

        N26 = new Location(
                "N26",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum N26.",
                false);

        NEUBAU = new Location(
                "Neubau",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich im Neubau.",
                false);

        NB101 = new Location(
                "101",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 101.",
                false);

        NB102 = new Location(
                "102",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 102.",
                false);

        NB103 = new Location(
                "103",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 103.",
                false);

        NB201 = new Location(
                "201",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 201.",
                false);

        NB202 = new Location(
                "202",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 202.",
                false);

        NB203 = new Location(
                "203",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 203.",
                false);

        NB301 = new Location(
                "301",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 301.",
                false);

        NB302 = new Location(
                "302",
                NonPlayerCharacter.EMPTY,
                new LinkedList<>(),
                "Du befindest dich in Raum 302.",
                false);

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
        NERDGESCHOSS.addItem(new Item("Schlüssel", "Mit einem Schlüssel kannst du verschlossene Türen aufschließen"));
    }

    public Location getStartLocation() {
        return START_ROOM;
    }
}