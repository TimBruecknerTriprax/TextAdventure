/**
 * Liste der Befehle
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */

public class CommandWords
{
    // Ein Array zum überprüfen der Befehle (Keine Erstellung, nur Überprüfung)
    private static final String[] validCommands = {
        "gehe", "quit", "hilfe","anzeigen"
    };

    /**
     * Initialisiert Befehle mit Werten.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Überprüft das String, ob ein Befehl vorhanden ist. 
     * @return true wenn der Befehl existiert,
     * false wenn er nicht existiert.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString))
                return true;
        }
        // Wenn die Schleife durchläuft ohne etwas zu finden existiert der Befehl nicht. Deshalb wird false zurückgegeben
        return false;
    }
}
