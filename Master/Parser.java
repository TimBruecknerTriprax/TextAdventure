import java.util.Scanner;

/**
 * Initialisiert die 2 Wörter, gleicht sie ab  mit Command Liste
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */
public class Parser 
{
    private CommandWords commands;  // enthält alle Befehle
    private Scanner reader;         // Eingabe der Befehle

    /**
     * Erstellt Scanner um Eingaben auszulesen.
     */
    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return The next command from the user.
     */
    public Command getCommand() 
    {
        String inputLine;   // Speichert die Eingabe
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // Eingabe Zeichen im Fenster

        inputLine = reader.nextLine();

        // Der Scanner findet 2 Wörter.
        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next();      // Speichern des ersten Worts
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next();      // Speichern des zweiten Worts
                // Der Rest der Eingabe wird ignoriert, bei Erweiterung zur 3 Wörter eingabe hier erweitern.
            }
        }

        // Es wird überprüft ob es den Befehl in Command gibt.Wenn ja werden die Befehle ausgegeben ansonsten wird es mit null als falsch markiert.
        if(commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            return new Command(null, word2); 
        }
    }
}
