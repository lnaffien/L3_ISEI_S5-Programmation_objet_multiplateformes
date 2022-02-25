/***********************************************************************************************************************************************

                                                                PartManagerLineaire
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package PartMatriceLineaire;

import Matrice.PartManager;

public class PartManagerLineaire implements PartManager
{
    /*************************************************
     * 
     *              Variables globales
     * 
     *************************************************/

    private PartDiagonal partDiag;  // Diagonale de la matrice.
    private PartSup partSup;        // Partie superieure de la matrice.
    private PartInf partInf;        // Partie inferieure de la matrice.

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice carree
     */
    public PartManagerLineaire(int taille)
    {        
        partDiag = new PartDiagonal(taille);
        partInf = new PartInf(taille);
        partSup = new PartSup(taille);
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Recupere un valeur stockée a une position donnee.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @return valeur a la position donnee
     */
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

    /**
     * Modifie une valeur a une position donnee dans la matrice.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
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

    /**
     * Affiche la matrice telle qu'elle est stockee.
     */
    public void afficherPartMatrice()
    {
        System.out.println("Diagonale :");
        partDiag.display();
        System.out.println("Partie inferieure :");
        partInf.display();
        System.out.println("Partie superieure :");
        partSup.display();
    }    

    /**
     * Transpose la matrice.
     */
    public void transposer()
    {
        for(int i = 0; i < partInf.values_array.length; i++)
        {
            int valeur_ecrasee = partInf.values_array[i] ;
            partInf.values_array[i] = partSup.values_array[i];
            partSup.values_array[i] = valeur_ecrasee;
        }
    }
    
}
