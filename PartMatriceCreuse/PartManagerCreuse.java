/***********************************************************************************************************************************************

                                                                PartManagerCreuse
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

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
        final int VALUES_ARRAY_OFFSET = ((PartCreuse)partInfCr).VALUES_ARRAY_OFFSET;
        final int VALUES_ARRAY_VALUE = ((PartCreuse)partInfCr).VALUES_ARRAY_VALUE;
        int[][] partSupTmp = partSupCr.values_array;

        // Suppression des donnees de la partie superieure
        while(partSupCr.values_array.length != 0)
        {
            offset = partSupCr.values_array[0][VALUES_ARRAY_OFFSET];
            supprimerValeur(partSupCr.getHauteur(offset), partSupCr.getLargeur(offset));
        }

        // Transposition de la partie inferieure vers la partie superieure
        while(partInfCr.values_array.length != 0)
        {            
            offset = this.partInfCr.values_array[0][VALUES_ARRAY_OFFSET];
            ajouterValeur(this.partInfCr.getLargeur(offset), this.partInfCr.getHauteur(offset), partInfCr.values_array[0][VALUES_ARRAY_VALUE]);
            // Suppression des valeurs de la partie inferieure ajoutees
            supprimerValeur(partInfCr.getHauteur(offset), partInfCr.getLargeur(offset));
        }

        // Transposition des anciennes donnees superieures vers la partie inferieure
        for(int i = 0; i < partSupTmp.length; i++)
        {
            offset = partSupTmp[i][VALUES_ARRAY_OFFSET];
            ajouterValeur(partSupCr.getLargeur(offset), partSupCr.getHauteur(offset), partSupTmp[i][VALUES_ARRAY_VALUE]);
        }
    }
    
}
