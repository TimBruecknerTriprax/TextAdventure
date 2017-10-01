
public class Gegenstand
{
   
    public int pBrenndauer;
    public int pSchaden;
    public int pRüstungswert;
    public int pSchnelligkeit; 
    // public int Cooldown;
    public int pSättigung;
    public int pDurstlöscher;
    /**
     * Konstruktor für Objekte der Klasse Objekte
     */
    public Gegenstand()
    {
        pBrenndauer = 0;
        pSchaden = 10;
        pRüstungswert = 0;
        pSchnelligkeit = 1;
        pSättigung = 1;
        pDurstlöscher = 1;
    }

    public void setBrenndauer (int newBrenndauer)
    {
       pBrenndauer= newBrenndauer;
  
    }
    
    public int getBrenndauer ()
    {
       return pBrenndauer;
  
    }
    
    public void setSchaden (int newSchaden)
    {
       pSchaden= newSchaden;
  
    }
    
    public int getSchaden ()
    {
       return pSchaden;
  
    }

    public void setRüstungswert (int newRüstungswert)
    {
       pRüstungswert= newRüstungswert;
  
    }
    
    public int getRüstungswert ()
    {
       return pRüstungswert;
  
    }

    public void setSchnelligkeit (int newSchnelligkeit)
    {
      pSchnelligkeit= newSchnelligkeit;
  
    }
    
    public int getSchnelligkeit ()
    {
       return pSchnelligkeit;
  
    }

    public void setSättigung (int newSättigung)
    {
       pSättigung= newSättigung;
  
    }
    
    public int getSättigung ()
    {
       return pSättigung;
  
    }

    public void setDurstlöscher (int newDurstlöscher)
    {
       pDurstlöscher= newDurstlöscher;
  
    }
    
    public int getDurstlöscher ()
    {
       return pDurstlöscher;
  
    }
}
