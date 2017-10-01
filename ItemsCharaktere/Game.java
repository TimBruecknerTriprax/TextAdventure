import java.util.*;

/**
 * Hauptspiele Methode (Räume, Befehle)
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private static int currentHours, currentMinutes, currentSeconds;
    private static int startHours, startMinutes, startSeconds;
    private java.util.Date now;   
   
    /**
     * Initialisierung des Spiels und der Map.
     * Erstellung des Parsers (überprüft die Eingabe mit Command).
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
        now = new java.util.Date();
        startHours = now.getHours();
        startMinutes = now.getMinutes(); 
        startSeconds = now.getSeconds(); 
    }

    /**
     * Erstellt die Räume und verbindet sie.
     */
    private void createRooms()
    {
        Room outside, theater, pub, lab, office;
      
        // erstellt die Räume + Beschreibung
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        
        // Verbindet die Räume untereinander (nördlich,östlich,südlich,westlich) null = kein Ausgang
        outside.setExits(null, theater, lab, pub);
        theater.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;  //Anfangsraum
    }
   
    public static void main(String[] args) {
     Game newGame = new Game();
     newGame.play();       
        
    }
    
    /**
     *  Standard Spiel Verfahren. Wiederholt sich bis das Spiel beendet wird.
     *  Ruft den Parser auf und vergleicht die Commands.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
        System.exit(0);
    }

    public static String getTime() {
        Date now2 = new java.util.Date();
        //currentHours = now2.getHours();
        currentMinutes = now2.getMinutes();
        //currentSeconds = now2.getSeconds(); 
        String timePlayed = (currentMinutes - startMinutes) + " Minutes.";
        return timePlayed;
        
    }
    
    /**
     * Startmeldung
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Willkommen im Jahre 2050!");
        System.out.println("Schau dich um und versuche zu überleben..");
        System.out.println("Schreibe 'hilfe' wenn du welche brauchst.");
        System.out.println();
        System.out.println("Du befindest dich gerade " + currentRoom.getDescription());
        System.out.print("Ausgänge: ");
        if(currentRoom.northExit != null) {
            System.out.print("nördlich ");
        }
        if(currentRoom.eastExit != null) {
            System.out.print("östlich ");
        }
        if(currentRoom.southExit != null) {
            System.out.print("südlich ");
        }
        if(currentRoom.westExit != null) {
            System.out.print("westlich ");
        }
        System.out.println();
    }

    /**
     * führt den Befehl aus. Hier werden die Befehle erstellt und müssen später in Command eingetragen werden. (Auch in Hilfe)
     * @param command The command to be processed.
     * @return wantToQuit wird solange wiederholt bis sich wantToQuit auf true ändert
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if(command.isUnknown()) {
            System.out.println("Mhm, das funktioniert nicht...");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("hilfe")) {
            printHelp();
        }
        else if (commandWord.equals("gehe")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        else if (commandWord.equals("anzeigen")) {
            Schmied.anzeigen();
        }

        return wantToQuit;
    }

    /**
     * Hilfestellung zum Spiel
     * Erstellt eine Naricht + die definierten Befehle
     */
    private void printHelp() 
    {
        System.out.println("Alles ist verlassen und zerstört...");
        System.out.println("Du solltest deinen Quest Log benutzen, schreibe dafür 'show quests'.");
        System.out.println();
        System.out.println("Die Befehle lauten:");
        System.out.println("   gehe quit hilfe");
    }

    /** 
     * Es wird versucht in eine Richtung zu gehen.
     * Wenn es einen Ausgang gibt wird in den Raum gewechselt.
     * Wenn nicht gibt es eine Fehlermeldung.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // Wenn das zweite Wort nach 'gehe' fehlt kommt diese Meldung...
            System.out.println("Wohin soll ich gehen?");
            return;
        }

        String direction = command.getSecondWord();

        // Es wird versucht in den nächsten Raum zu gehen
        Room nextRoom = null;
        if(direction.equals("nördlich")) {
            nextRoom = currentRoom.northExit;
        }
        if(direction.equals("östlich")) {
            nextRoom = currentRoom.eastExit;
        }
        if(direction.equals("südlich")) {
            nextRoom = currentRoom.southExit;
        }
        if(direction.equals("westlich")) {
            nextRoom = currentRoom.westExit;
        }

        if (nextRoom == null) {
            System.out.println("Da geht es nicht weiter!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println("Du bist " + currentRoom.getDescription());
            System.out.print("Wege: ");
            if(currentRoom.northExit != null) {
                System.out.print("nördlich ");
            }
            if(currentRoom.eastExit != null) {
                System.out.print("östlich ");
            }
            if(currentRoom.southExit != null) {
                System.out.print("südlich ");
            }
            if(currentRoom.westExit != null) {
                System.out.print("westlich ");
            }
            System.out.println();
            System.out.println("Du spielst schon seit " + getTime());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
    
}
