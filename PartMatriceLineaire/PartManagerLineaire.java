package PartMatriceLineaire;

import Matrice.PartManager;

public class PartManagerLineaire implements PartManager
{    
    private PartDiagonal partDiag;  // Diagonale de la matrice.
    private PartSup partSup;        // Partie superieure de la matrice.
    private PartInf partInf;        // Partie inferieure de la matrice.

    public PartManagerLineaire(int taille)
    {        
        partDiag = new PartDiagonal(taille);
        partInf = new PartInf(taille);
        partSup = new PartSup(taille);
    }

    public int getValueFromIndex(int hauteur, int largeur)
    {
        if(hauteur == largeur)
        {
            return partDiag.getValueFromIndex(hauteur);
        }
        else if(hauteur > largeur)
        {
            return partInf.getValueFromIndex(hauteur, largeur);
        }
        else
        {
            return partSup.getValueFromIndex(hauteur, largeur);
        }
    }

    public void ajouterValeur(int hauteur, int largeur, int valeur)
    {
        if(hauteur == largeur)
        {
            partDiag.ajouterValeur(hauteur, valeur);
        }
        else if(hauteur > largeur)
        {
            partInf.ajouterValeur(hauteur, largeur, valeur);
        }
        else
        {
            partSup.ajouterValeur(hauteur, largeur, valeur);
        }

    }

    public void afficherPartMatrice()
    {
        System.out.println("Diagonale :");
        partDiag.display();
        System.out.println("Partie inferieure :");
        partInf.display();
        System.out.println("Partie superieure :");
        partSup.display();
    }    

    public PartManagerLineaire transposer()
    {
        PartManagerLineaire res_lineaire = new PartManagerLineaire(partSup.taille);
        res_lineaire.partDiag = this.partDiag;

        for(int i = 0; i < res_lineaire.partInf.values_array.length; i++)
        {
            int valeur_ecrasee = res_lineaire.partInf.values_array[i] ;
            res_lineaire.partInf.values_array[i] = res_lineaire.partSup.values_array[i];
            res_lineaire.partSup.values_array[i] = valeur_ecrasee;

        }

        

        return res_lineaire;
    }
    
}
