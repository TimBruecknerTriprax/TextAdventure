
/**
 * Die Klasse Mensch ist die Hauptklasse aller Charaktere mit ausnahme von Feinden.
 * 
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */
public class Mensch
{
    public String pName;
    //public int pErfahrung;
    public int pLeben;
    public int pIntelligenz;
    public int pAngriff;
    public int pRüstung;
    public int pGeschwindigkeit;
    public int pAusdauer;
    //public int pCooldown;
    public int pHunger;
    public int pDurst;
    
    public Mensch()
    {
      pName = "Unbekannter";
      //pErfahrung = 0;
      //pCooldown = 0;
      pLeben = 100;
      pIntelligenz = 50;
      pAngriff = 50;
      pRüstung = 0;
      pGeschwindigkeit= 50;
      pAusdauer = 10;
      pHunger = 0;
      pDurst = 0;
    }

    public void setName(String newName)
    {
       pName= newName;
  
    }
    
    public String getName()
    {
       return pName;
  
    }
    
     public void setGeschwindikeit(int newGeschwindigkeit)
    {
       pGeschwindigkeit = newGeschwindigkeit;
  
    }
    
     public int getGeschwindigkeit()
    {
       return pGeschwindigkeit;
  
    }
    
    
    public void setLeben(int newLeben)
    {
       pLeben= newLeben ;
  
    }
    
    public int getLeben()
    {
       return pLeben;
  
    }
    
    public void setIntelligenz(int newIntelligenz)
    {
       pIntelligenz= newIntelligenz ;
  
    }
    
    public int getIntelligenz()
    {
       return pIntelligenz;
  
    }
    
    public void setAngriff(int newAngriff)
    {
       pAngriff= newAngriff ;
  
    }
    
    public int getAngriff()
    {
       return pAngriff;
  
    }
    
    public void setRüstung(int newRüstung)
    {
       pRüstung= newRüstung ;
  
    }
    
    public int getRüstung()
    {
       return pRüstung;
  
    }
    
    public void setAusdauer(int newAusdauer)
    {
       pAusdauer= newAusdauer ;
  
    }
    
    public int getAusdauer()
    {
       return pAusdauer;
  
    }
    
    public void setHunger(int newHunger)
    {
       pHunger= newHunger ;
  
    }
    
    public int getHunger()
    {
       return pHunger;
  
    }
    
    public void setDurst(int newDurst)
    {
       pDurst= newDurst ;
  
    }
    
    public int getDurst()
    {
       return pDurst;
  
    }

    
    
}
