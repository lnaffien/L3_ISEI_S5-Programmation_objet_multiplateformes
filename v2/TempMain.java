import PartMatrice.PartDiagonalCreuse;

public class TempMain
{
    public static void main(String arg[])
    {
        PartDiagonalCreuse pdc = new PartDiagonalCreuse(5);
        pdc.ajouterValeur(0, 1);
        pdc.ajouterValeur(0, 0);
        pdc.display();
    }
    
}
