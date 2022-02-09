import PartMatrice.PartDiagonalCreuse;
import PartMatrice.PartInfCreuse;

public class TempMain
{
    public static void main(String arg[])
    {
        PartInfCreuse pdc = new PartInfCreuse(5);
        pdc.ajouterValeur(1, 0, -1);
        pdc.ajouterValeur(2, 1, -3);
        pdc.display();
    }
    
}
