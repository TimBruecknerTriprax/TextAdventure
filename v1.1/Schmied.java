
public class Schmied extends Hauptcharakter 
  {
    public Schmied()
    {
      super.pName = "Unbekannter";
      //super.pErfahrung = 0;
      //super.pCooldown = 0;
      super.pLeben = 100;
      super.pIntelligenz = 50;
      super.pAngriff = 50;
      super.pRüstung = 0;
      super.pGeschwindigkeit= 50;
      super.pAusdauer = 10;
      super.pHunger = 0;
      super.pDurst = 0;
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
