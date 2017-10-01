
/**
 * Beschreiben Sie hier die Klasse Schmied.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Schmied extends Mensch 
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
    private String Name;
    private int Leben;
    private int Intelligenz;
    private int Angriff;
    private int Rüstung;
    private int Geschwindigkeit;
    private int Ausdauer;
    private int Hunger;
    private int Durst;
    int[]rucksack= new int[10];
    //private int rucksack;
    //rucksack[] = new Gegenstand[10];
    /**
     * Konstruktor für Objekte der Klasse Schmied
     */
    public Schmied()
    {
        Name = "Unbekannter";
      //Erfahrung = 0;
      //Cooldown = 0;
      Leben = 100;
      Intelligenz = 50;
      Angriff = 50;
      Rüstung = 0;
      //Geschwindigkeit= 50;
      Ausdauer = 10;
      Hunger = 0;
      Durst = 0;
    }
    public void nehmen(){
    
    
    }
    public void anzeigen()
    {
       for (int i=0; i<=9; i++)
       {
         
          System.out.println(i+"---------------------------");
       }
      
}
}
