package PartMatriceCreuse;

import Matrice.PartManager;

public class PartManagerCreuse implements PartManager
{    
    PartDiagonalCreuse partDiagCr;  // Diagonale de la matrice creuse.
    PartSupCreuse partSupCr;        // Partie superieure de la matrice creuse.
    PartInfCreuse partInfCr;        // Partie inferieure de la matrice creuse.

    public PartManagerCreuse(int taille)
    {        
        partDiagCr = new PartDiagonalCreuse(taille);
        partSupCr = new PartSupCreuse(taille);
        partInfCr = new PartInfCreuse(taille);
    }

    public int getValueFromIndex(int hauteur, int largeur)
    {
        if(hauteur == largeur)
        {
            return partDiagCr.getValueFromIndex(hauteur);
        }
        else if(hauteur > largeur)
        {
            return partInfCr.getValueFromIndex(hauteur, largeur);
        }
        else
        {
            return partSupCr.getValueFromIndex(hauteur, largeur);
        }
    }

    public void ajouterValeur(int hauteur, int largeur, int valeur)
    {
        if(hauteur == largeur)
        {
            partDiagCr.ajouterValeur(hauteur, valeur);
        }
        else if(hauteur > largeur)
        {
            partInfCr.ajouterValeur(hauteur, largeur, valeur);
        }
        else
        {
            partSupCr.ajouterValeur(hauteur, largeur, valeur);
        }

    }

    public void supprimerValeur(int hauteur, int largeur)
    {
        if(hauteur == largeur)
        {
            partDiagCr.supprimerValeur(hauteur);
        }
        else if(hauteur > largeur)
        {
            partInfCr.supprimerValeur(hauteur, largeur);
        }
        else
        {
            partSupCr.supprimerValeur(hauteur, largeur);
        }
    }

    public void afficherPartMatrice()
    {
        System.out.println("Diagonale :");
        partDiagCr.display();
        System.out.println("Partie inferieure :");
        partInfCr.display();
        System.out.println("Partie superieure :");
        partSupCr.display();
    }    

    public void transposer()
    {
        int offset;
        PartSupCreuse partSupTmp = partSupCr;

        for(int i = 0; i < partInfCr.values_array.length; i++)
        {            
            offset = this.partInfCr.values_array[i][((PartCreuse)partInfCr).VALUES_ARRAY_OFFSET];
            ajouterValeur(this.partInfCr.getLargeur(offset), this.partInfCr.getHauteur(offset), partInfCr.values_array[i][((PartCreuse)partInfCr).VALUES_ARRAY_VALUE]);
            supprimerValeur(partInfCr.getHauteur(offset), partInfCr.getLargeur(offset));
        }

        for(int i = 0; i< partSupTmp.values_array.length; i++)
        {
            offset = partSupTmp.values_array[i][((PartCreuse)partInfCr).VALUES_ARRAY_OFFSET];
            ajouterValeur(partSupTmp.getLargeur(offset), partSupTmp.getHauteur(offset), partSupTmp.values_array[i][((PartCreuse)partSupTmp).VALUES_ARRAY_VALUE]);
        }
    }
    
}
