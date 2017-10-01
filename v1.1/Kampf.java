
import java.util.*;
import java.util.Scanner;
public class Kampf
{


    private Parser BattleParser;
    String pBattleEingabe;
    Scanner b = new Scanner(System.in);
    
    Feind Monster = new Feind();
    Schmied Charakter = new Schmied();
    
    String pNameFeind;
    String pNameCharakter;
    
    int pGeschwindigkeitCharakter;
    int pGeschwindigkeitFeind;
    
    double pLebenCharakter;
    double pLebenFeind;
    
    double pAngriffCharakter;
    double pAngriffFeind;
    
    double  pSchadenErziehlt;
    public Kampf()
    {
     pNameFeind = Monster.getName();
     pNameCharakter = Charakter.getName();
     pGeschwindigkeitCharakter = Charakter.getGeschwindigkeit();
     pGeschwindigkeitFeind = Monster.getGeschwindigkeit();
     pLebenCharakter = Charakter.getLeben();
     pLebenFeind = Monster.getLeben();
     pAngriffCharakter = Charakter.getAngriff();
     pAngriffFeind = Monster.getAngriff();
   
  }   
  
  public void StartKampf(){
     System.out.println(pNameFeind+" verwickelt dich in einen Kampf!");
     pause(2000);
     System.out.println("Möchtest du 'kämpfen' oder 'fliehen'?");
     System.out.print("> ");
     pBattleEingabe = b.next();
     
     if(pBattleEingabe.equals("kämpfen")){
         Kampfmodus();}
     else if(pBattleEingabe.equals("fliehen")){
        if(pGeschwindigkeitCharakter>pGeschwindigkeitFeind){
            if(pGeschwindigkeitCharakter*(Math.random()*10)>100){
                System.out.println("");
                System.out.println("Du bist vor "+pNameFeind+" geflohen!");
                
             } else{System.out.println("");
                    System.out.println("Du schaffst es nicht "+pNameFeind+" zu entkommen!");
                    Kampfmodus();}
            } 
        else{System.out.println("");
             System.out.println("Du bist zu langsam dafür!");
             Kampfmodus();}
    }
    else{System.out.println("");
         System.out.println("Gib eine gültige Option ein!");
         StartKampf();
    }
    }
  private void Kampfmodus(){
   while(pLebenCharakter>0&&pLebenFeind>0){
                        
      if(pGeschwindigkeitCharakter>pGeschwindigkeitFeind){
        Angriff();
        System.out.println("");  
        System.out.println("Du fügst "+pNameFeind+" "+ pSchadenErziehlt+" Schaden zu.");
        pause(2000);
        System.out.println("");
        System.out.println("Du hast noch "+pLebenCharakter+" Leben!");
        System.out.println(pNameFeind+" hat noch "+pLebenFeind+" Leben!");
        System.out.println("");
        }
      else{
       System.out.println("");   
       pLebenCharakter = pLebenCharakter-pAngriffFeind;
       System.out.println( pNameFeind+" fügt "+pNameCharakter+" "+pAngriffFeind+" Schaden zu.");
       pause(2000);
       System.out.println("");
       System.out.println("Du hast noch "+pLebenCharakter+" Leben!");
       System.out.println(pNameFeind+" hat noch "+pLebenFeind+" Leben!");
       System.out.println("");
        }
      if(pGeschwindigkeitCharakter>pGeschwindigkeitFeind){
       System.out.println("");   
       pLebenCharakter = pLebenCharakter-pAngriffFeind;
       System.out.println( pNameFeind+" fügt "+pNameCharakter+" "+pAngriffFeind+" Schaden zu.");
       pause(2000);
       System.out.println("");
       System.out.println("Du hast noch "+pLebenCharakter+" Leben!");
       System.out.println(pNameFeind+" hat noch "+pLebenFeind+" Leben!");
       System.out.println("");
      }
      else{
        Angriff();
        System.out.println("");  
        System.out.println("Du fügst "+pNameFeind+" "+ pSchadenErziehlt+" Schaden zu.");
        pause(2000);
        System.out.println("");
        System.out.println("Du hast noch "+pLebenCharakter+" Leben!");
        System.out.println(pNameFeind+" hat noch "+pLebenFeind+" Leben!");
        System.out.println("");
      }  
      
      if(pLebenCharakter>0&&pLebenFeind>0){System.out.println(""); 
      System.out.println("Nächste Runde!");
      System.out.println("");
     }

    }
    
    pause(2000);
      
    if(pLebenCharakter<=0){
      System.out.println(""); 
      System.out.println("Der Kampf ist vorbei "+pNameFeind+" gewinnt!");
      System.out.println(""); 
      }  
    else{System.out.println(""); 
      System.out.println("Der Kampf ist vorbei "+pNameCharakter+" gewinnt!");
      System.out.println("");
      }
   }
    
   private void Angriff(){
    System.out.println("Wie willst du angreifen: mit 'Tritt','Hieb','Schlag'?");
    System.out.print("> ");
    pBattleEingabe = b.next();
    if(pBattleEingabe.equals("Tritt")){
        pause(1000);
        System.out.println("");
        System.out.println("Du trittst "+pNameFeind+"!");
        pLebenFeind = pLebenFeind-(pAngriffCharakter*0.5);
        pSchadenErziehlt=pAngriffCharakter*0.5;
    }
        
    else if(pBattleEingabe.equals("Hieb")){
       if( Math.random()*10>7){
         pause(1000);
         System.out.println("");
         System.out.println("Du triffst "+pNameFeind+"!");
         pLebenFeind = pLebenFeind-(pAngriffCharakter*0.75);
         pSchadenErziehlt=pAngriffCharakter*0.75;
        } 
       else{
          pause(1000);
          System.out.println("");
          System.out.println("Du schaffst es nicht "+pNameFeind+" zu treffen!");
          pause(1000);
        }
    }
    else if (pBattleEingabe.equals("Schlag")){
        if( Math.random()*10>5){
         pause(1000);
         System.out.println("");
         System.out.println("Du schlägst "+pNameFeind+"!");
         pLebenFeind = pLebenFeind-(pAngriffCharakter*1);
         pSchadenErziehlt=pAngriffCharakter*1;
        } 
        else{
          pause(1000);
          System.out.println("");
          System.out.println("Du schaffst es nicht "+pNameFeind+" zu treffen!");
          pause(1000);
        }
    }
    else{
        pause(1000);
        System.out.println("");
        System.out.println("Das kannst du noch nicht! Vielleicht solltest du ein Dojo besuchen!");
        Angriff();
    }
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
}
