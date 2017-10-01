
public class Heilblatt extends Gegenstand
{
    int pLebenNachHeilung;
    int pLebenVorHeilung;
    int Heilwert = 20;
    public Heilblatt()
    {
       // pLebenNachHeilung = Charakter.getLeben();
       //Hauptcharakter Charakter
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