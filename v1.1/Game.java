import java.util.*;
import java.util.Scanner;
/**
 * Hauptspiele Methode (Räume, Befehle)
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */

public class Game 
{
    public Map playground;
    public Kampf Kampf;
    
    private Parser parser;
    Scanner s = new Scanner(System.in);
    
    private static int currentHours, currentMinutes, currentSeconds;
    private static int startHours, startMinutes, startSeconds;
    private java.util.Date now; 
    
    private String pCharacter;
    private String pEingabe;
    
    public int CharakterX;
    public int CharakterY;

    /**
     * Initialisierung des Spiels und der Map.
     * Erstellung des Parsers (überprüft die Eingabe mit Command).
     */
    public Game() 
    {
        playground = new Map();
        Kampf = new Kampf();
        
        parser = new Parser();
        
        now = new java.util.Date();
        startHours = now.getHours();
        startMinutes = now.getMinutes(); 
        startSeconds = now.getSeconds(); 
        
        //spawn
        CharakterX = 7;
        CharakterY = 7;
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
        selectScreenCharacter();
        
        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.
                
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Auf Wiedersehen!");
        System.exit(0);
    }

    public static String getTime() {
        Date now2 = new java.util.Date();
        currentMinutes = now2.getMinutes();
        
        String timePlayed = (currentMinutes - startMinutes) + " Minutes.";
        
        return timePlayed;    
    }
    
    /**
     * Startmeldung
     */
    private void printWelcome()
    {
        System.out.println("");
        System.out.println("Willkommen im Jahre 2050!");
        pause(5000);
        
        System.out.println("Um dich herum ist alles zerstört..");
        System.out.println("Überall siehst du zusammengestürzte Häuser");
        pause(7000);
        
        System.out.println("Du kannst dich noch an eine Explosion erinnern");
        pause(4000);
        
        System.out.println("Vielleicht solltest du die Gegend erkunden.");
        pause(4000);
        
        System.out.println("");
        System.out.println("Schreibe 'hilfe' wenn du welche brauchst.");
        System.out.println();
        pause(2000);
        
        System.out.println("Du befindest dich gerade "+playground.neueMap[CharakterX][CharakterY]);
        System.out.print("Wege: ");
        SucheAusgänge();
        System.out.println();
    }
    
    public void pause(int Zeit){
        try        
       {
          Thread.sleep(Zeit);
       } 
         catch(InterruptedException ex) 
       {
        Thread.currentThread().interrupt();
         }   
    }
    
     /**
     * Charakter Wahl
     */
    private void selectScreenCharacter(){
      System.out.println("");
      pause(1500);
      
      System.out.println("Erinnerst du dich, was du früher einmal warst?");
      System.out.println("Schmied, Dieb, Arzt, Boxer");
      System.out.print("> ");
      
      pEingabe = s.next();
      
      selectCharacter(pEingabe);
    }
    
     /**
     * Charakter Wahl
     */
    private void selectCharacter(String pEingabe){
      
      if (pEingabe.equals("Schmied")){
          pCharacter = "Schmied";
          Schmied Charakter = new Schmied();
          pause(1000);
          
          System.out.println("Wie heißt du?");
          System.out.print("> ");
          pEingabe = s.next();
          Charakter.setName(pEingabe);
        }
      else if (pEingabe.equals("Dieb")) {
          pCharacter = "Dieb"; 
          Dieb Charakter = new Dieb();
          pause(1000);
          
          System.out.println("Wie heißt du?");
          System.out.print("> ");
          pEingabe = s.next();
          Charakter.setName(pEingabe);
        }
      else if (pEingabe.equals("Arzt")) {
          pCharacter = "Arzt"; 
          Arzt Charakter = new Arzt();
          pause(1000);
          
          System.out.println("Wie heißt du?");
          System.out.print("> ");
          pEingabe = s.next();
          Charakter.setName(pEingabe);
        }
      else if (pEingabe.equals("Boxer")) {
          pCharacter = "Boxer";
          Boxer Charakter = new Boxer();
          pause(1000);
      
          System.out.println("Wie heißt du?");
          System.out.print("> ");
          pEingabe = s.next();
          Charakter.setName(pEingabe);
        }
      else{ pause(1000);
            System.out.println("Falsche Eingabe");
            
            selectScreenCharacter();
        }
        
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
            goRoom(command, playground);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
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

    

    private void goRoom(Command command, Map neueMap) 
    {
        if(!command.hasSecondWord()) {
            // Wenn das zweite Wort nach 'gehe' fehlt kommt diese Meldung...
            System.out.println("Wohin soll ich gehen?");
            return;
        }

        String direction = command.getSecondWord();

        // Es wird versucht in den nächsten Raum zu gehen
        if(direction.equals("nördlich")) {
           if (playground.neueMap[CharakterX][CharakterY+1] != null) {
            System.out.println("Da geht es nicht weiter!");
           }
           else{
            CharakterY = CharakterY + 1;
          }
        }
        if(direction.equals("östlich")) {
            if (playground.neueMap[CharakterX+1][CharakterY] != null) {
            System.out.println("Da geht es nicht weiter!");
           }
           else{
            CharakterX = CharakterX + 1;
          }
        }
        if(direction.equals("südlich")) {
            if (playground.neueMap[CharakterX][CharakterY-1] != null) {
            System.out.println("Da geht es nicht weiter!");
           }
           else{ 
               CharakterY = CharakterY - 1;
            }
        }
        if(direction.equals("westlich")) {
            if (playground.neueMap[CharakterX-1][CharakterY] != null) {
            System.out.println("Da geht es nicht weiter!");
           }
            CharakterX = CharakterX - 1;
        }
        
            System.out.print("Wege: ");
            SucheAusgänge();
            
            System.out.println();
            System.out.println("Du spielst schon seit " + getTime());
        
    }
    
    private void SucheAusgänge(){
       if (playground.neueMap[CharakterX][CharakterY+1] != null) {
            System.out.print("nicht nördlich,");
           } else{System.out.print("nördlich,"); }
       if (playground.neueMap[CharakterX][CharakterY-1] != null) {
            System.out.print("nicht südlich,");
           }  else{System.out.println("südlich,"); }
       if (playground.neueMap[CharakterX+1][CharakterY] != null) {
            System.out.print("nicht östlich,");
           } else{System.out.print("östlich,"); } 
       if (playground.neueMap[CharakterX-1][CharakterY] != null) {
            System.out.print("nicht westlich");
           } else{System.out.print("westlich"); } 
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
