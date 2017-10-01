
/**
 * Die Klasse Mensch ist die Hauptklasse aller Charaktere mit ausnahme von Feinden.
 * 
 * @author (Max, Noah, Tim) 
 * @version (0.0.1 04.09.2017)
 */
public class Mensch
{
    private String Name;
    //private int Erfahrung;
    private int Leben;
    private int Intelligenz;
    private int Angriff;
    private int Rüstung;
    private int Geschwindigkeit;
    private int Ausdauer;
    //private int Cooldown;
    private int Hunger;
    private int Durst;
    
    public Mensch()
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

    public void setName(String pName)
    {
       Name= pName;
  
    }
    
    public String getName()
    {
       return Name;
  
    }
    
    public void setLeben(int pLeben)
    {
       Leben= pLeben ;
  
    }
    
    public int getLeben()
    {
       return Leben;
  
    }
    
    public void setIntelligenz(int pIntelligenz)
    {
       Intelligenz= pIntelligenz ;
  
    }
    
    public int getIntelligenz()
    {
       return Intelligenz;
  
    }
    
    public void setAngriff(int pAngriff)
    {
       Angriff= pAngriff ;
  
    }
    
    public int getAngriff()
    {
       return Angriff;
  
    }
    
    public void setRüstung(int pRüstung)
    {
       Rüstung= pRüstung ;
  
    }
    
    public int getRüstung()
    {
       return Rüstung;
  
    }
    
    public void setAusdauer(int pAusdauer)
    {
       Ausdauer= pAusdauer ;
  
    }
    
    public int getAusdauer()
    {
       return Ausdauer;
  
    }
    
    public void setHunger(int pHunger)
    {
       Hunger= pHunger ;
  
    }
    
    public int getHunger()
    {
       return Hunger;
  
    }
    
    public void setDurst(int pDurst)
    {
       Durst= pDurst ;
  
    }
    
    public int getDurst()
    {
       return Durst;
  
    }

    
    
}
