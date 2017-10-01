
public class Verband extends Gegenstand
{
    //pLebenNachHeilung = Charakter.getLeben();
    int pLebenNachHeilung;
    int pLebenVorHeilung;
    int Heilwert = 50;
    public Verband()
    {
        
    }

   
    public int nehmen(int pHP)
    {
       pLebenNachHeilung= pLebenVorHeilung + Heilwert;
       if (pLebenNachHeilung > 100){
           pLebenNachHeilung=100;
           System.out.println("Du bist nun voll geheilt.");
        }
        if(pLebenNachHeilung <= 100){
        System.out.println("Du hast nun"+pLebenNachHeilung+"Leben.");
        }
        System.out.println ("Dir geht es gleich viel Besser. Du hast nun Leben"+pLebenNachHeilung);
        return pHP;
    }
}
