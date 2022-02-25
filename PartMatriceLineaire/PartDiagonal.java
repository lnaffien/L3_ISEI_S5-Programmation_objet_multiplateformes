/***********************************************************************************************************************************************

                                                                PartDiagonal
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package PartMatriceLineaire;

public class PartDiagonal extends PartLineaire
{
    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice caree
     */
    protected PartDiagonal(int taille)
    {
        super(taille);
        values_array = new int[taille];
    }

     /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Retourne la valeur stockee a une position donnee dans la matrice.
     * @param index position dans la hauteur et dans la largeur de la matrice
     * @return valeur stockee a la position donnee
     */
    protected int getValueFromIndex(int index)
    {
        // Verification de la validite des index donnes.
        if(index >= taille || index < 0)
        {
            throw new ArithmeticException("PartDiagonal : getValueFromIndex : index invalide.");
        }
        return values_array[index];
    }

    /**
     * Modifie une valeur a une position donnee dans la matrice.
     * @param index position dans la hauteur et dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    protected void ajouterValeur(int index, int valeur)
    {
        if(index >= taille || index < 0)
        {
            throw new ArithmeticException("PartDiagonal : addValue : index invalide");
        }
        values_array[index] = valeur;
    }

    /**
     * Affiche la diagonale de la matrice.
     */
    protected void display()
    {
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
        }
        System.out.println();
    }
}
