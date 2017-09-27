/**
 *  Enthält Regeln zur verarbeitung der Befehle.
 *  Ein Befehl besteht aus 2 Strings z.B. 'gehe westlich'
 *  
 * The way this is used is: Commands are already checked for being valid
 * command words. If the user entered an invalid command (a word that is not
 * known) then the command word is <null>.
 *
 * If the command had only one word, then the second word is <null>.
 * 
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */

public class Command
{
    private String commandWord;
    private String secondWord;

    /**
     * Eingegebenen Wörter werden gespiechert.
     * @param firstWord Das erste Wort. Enthält 'null' wenn der Befehl nicht erkannt wurde.
     * @param secondWord Das zweite Wort.
     */
    public Command(String firstWord, String secondWord)
    {
        commandWord = firstWord;               // CommandWord weil es den befehl angibt wie gehe, nehme
        this.secondWord = secondWord;          // secondWord kann alles definierte sein. (in Spiel)
    }

    /**
     * Gibt das commandWord, also das erste Wort aus.
     * Es enthält 'null' wenn es nicht erkannt wurde.
     */
    public String getCommandWord()
    {
        return commandWord;
    }

    /**
     * Gibt das second Wort aus.
     * Es enthält 'null' wenn es nicht erkannt wurde.
     */
    public String getSecondWord()
    {
        return secondWord;
    }

    /**
     * @return true wenn die Eingabe nicht verstanden wurde,
     */
    public boolean isUnknown()
    {
        return (commandWord == null);
    }

    /**
     * @return true wenn die Eingabe aus 2 Wörtern besteht.
     */
    public boolean hasSecondWord()
    {
        return (secondWord != null);
    }
}

