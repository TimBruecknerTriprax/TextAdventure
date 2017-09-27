
/**
 * Beschreiben Sie hier die Klasse Kampf.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Kampf
{


    private Parser BattleParser;
    String pBattleEingabe;
    /**
     * Konstruktor für Objekte der Klasse Kampf
     */
    public Kampf()
    {
     System.out.println(pNameFeind+" verwickelt dich in einen Kampf!");
     System.out.println("Möchtest du 'kämpfen' oder 'fliehen'?");
     Scanner b = new Scanner(System.in);
     pBattleEingabe = b.next();
     
     if(pBattleEingabe.equals=="kämpfen"){
         Kampfmodus();}
     else if(pBattleEingabe.equals=="fliehen"){
        if(pGeschwindigkeitCharakter>pGeschwindigkeitFeind){
            if(pGeschwindigkeitCharakter*(Math.random()*10)>100){
                System.out.println("Du bist vor"+pNameFeind+"geflohen!");
                KampfBeenden();
             }
            }
    }
    else{System.out.println("Gib eine gültige Option ein!");
        Kampf();
    }
    
   
}   
    
private void Kampfmodus(){
   int Runden = 0;
   int pLeben = 10;
   int pLebenFeind = 10;
   while(pLebenCharakter>0||pLebenFeind>0){
      int g1 = getGeschwindigkeitHauptcharakter();
      int g2 = getGeschwindigkeitFeind();
      int h1 = getLebenHauptcharakter();
      int h2 = getLebenFeind();
            
            
      if(g1>g2){Angriff();
        System.out.println("Du fügst"+pNameFeind+pAngriffCharakter+"Schaden zu.");
        }
      else{Angriff();
       System.out.println( pNameFeind+"fügt"+Charakter+pAngriffFeind+"Schaden zu.");
        }
      if(g1>g2){Angriff();
        System.out.println( pNameFeind+"fügt"+Charakter+pAngriffFeind+"Schaden zu.");
      }
      else{Angriff();
        System.out.println("Du fügst"+pNameFeind+pAngriffCharakter+"Schaden zu.");
      }
            
      System.out.println("Du hast noch"+pLebenCharakter+"Leben!");
      System.out.println(pNameFeind+" hat noch"+pLebenFeind+"Leben!");
    }
}
    
private void Angriff(){
    System.out.println("Wie willst du angreifen: mit 'Tritt','Seitenhieb','Hieb von Oben'?");
    pBattleEingabe = b.next();
    if(pBattleEingabe.equals=="Tritt"){
        System.out.println("Du trittst"+pNameFeind+"!");
        pLebenFeind = pLebenFeind-(pAngriffCharakter*0.5);
    }
        
    else if(pBattleEingabe.equals=="Seitenhieb"){
       if( Math.random()*10>7){
          System.out.println("Du schlägst"+pNameFeind+"!");
         pLebenFeind = pLebenFeind-(pAngriffCharakter*0.75);
        }     
    }
    else if (pBattleEingabe.equals=="Hieb von Oben"){
        if( Math.random()*10>5){
          System.out.println("Du zerschmetterst"+pNameFeind+"!");
         pLebenFeind = pLebenFeind-(pAngriffCharakter*1);
        } 
    }
    else{System.out.println("Das kannst du noch nicht! Vielleicht solltest du ein Dojo besuchen!");
         Angriff();
    }
}
}
