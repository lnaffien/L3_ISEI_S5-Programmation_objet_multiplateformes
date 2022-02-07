package PartMatrice;

public class PartManager
{
    int size;               // Taille de la matrice carree.
    
    PartDiagonal partDiag;  // Diagonale de la matrice.
    PartSup partSup;        // Partie superieure de la matrice.
    PartInf partInf;        // Partie inferieure de la matrice.

    public PartManager(int taille)
    {        
        partDiag = new PartDiagonal(taille);
        partInf = new PartInf(taille);
        partSup = new PartSup(taille);
    }

    public int getValueFromIndex(int x, int y)
    {
        if(x == y)
        {
            return partDiag.getValueFromIndex(x);
        }
        else if(x > y)
        {
            return partInf.getValueFromIndex(x, y);
        }
        else
        {
            return partSup.getValueFromIndex(x, y);
        }
    }

    public void addValue(int x, int y, int valeur)
    {
        if(x == y)
        {
            partDiag.addValue(x, valeur);
        }
        else if(x > y)
        {
            partInf.addValue(x, y, valeur);
        }
        else
        {
            partSup.addValue(x, y, valeur);
        }

    }
    
}
