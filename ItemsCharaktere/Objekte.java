
/**
 * Beschreiben Sie hier die Klasse Objekte.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Objekte
{
    // Instanzvariablen - ersetzen Sie das folgende Beispiel mit Ihren Variablen
   
    private int Brenndauer;
    
    
    private int Schaden;
    private int Rüstungswert;
    private int Schnelligkeit;
    
    //private int Cooldown;
    private int Sättigung;
    private int Durstlöscher;
    /**
     * Konstruktor für Objekte der Klasse Objekte
     */
    public Objekte()
    {
        // Instanzvariable initialisieren
        Brenndauer = 0;
        Schaden = 10;
        Rüstungswert = 0;
        Schnelligkeit = 1;
        Sättigung = 1;
        Durstlöscher = 1;
    }

    public void setBrenndauer (int pBrenndauer)
    {
       Brenndauer= pBrenndauer;
  
    }
    
    public int getBrenndauer ()
    {
       return Brenndauer;
  
    }
    
    public void setSchaden (int pSchaden)
    {
       Schaden= pSchaden;
  
    }
    
    public int getSchaden ()
    {
       return Schaden;
  
    }

    public void setRüstungswert (int pRüstungswert)
    {
       Rüstungswert= pRüstungswert;
  
    }
    
    public int getRüstungswert ()
    {
       return Rüstungswert;
  
    }

    public void setSchnelligkeit (int pSchnelligkeit)
    {
       Schnelligkeit= pSchnelligkeit;
  
    }
    
    public int getSchnelligkeit ()
    {
       return Schnelligkeit;
  
    }

    public void setSättigung (int pSättigung)
    {
       Sättigung= pSättigung;
  
    }
    
    public int getSättigung ()
    {
       return Sättigung;
  
    }

    public void setDurstlöscher (int pDurstlöscher)
    {
       Durstlöscher= pDurstlöscher;
  
    }
    
    public int getDurstlöscher ()
    {
       return Durstlöscher;
  
    }
}
