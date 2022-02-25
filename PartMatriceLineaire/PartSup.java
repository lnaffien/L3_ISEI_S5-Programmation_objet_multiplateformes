/***********************************************************************************************************************************************

                                                                PartSup
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package PartMatriceLineaire;

class PartSup extends PartLineaire
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
    protected PartSup(int taille)
    {
        super(taille);
        values_array = new int[((taille * taille) - taille) / 2];
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Retourne la valeur stockee a une position donnee dans la matrice.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @return valeur stockee a la position donnee
     */
    protected int getValueFromIndex(int hauteur, int largeur)
    {
        // Verification de la validite des index donnes.
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille)
        {
            throw new ArithmeticException("PartInf : getValueFromIndex : index invalide :"  + hauteur + ", " + largeur);
        }
        return values_array[hauteur * taille + largeur - exp(hauteur) - hauteur - 1];
    }

    /**
     * Modifie une valeur a une position donnee dans la matrice.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @param value nouvelle valeur a ajouter
     */
    protected void ajouterValeur(int hauteur, int largeur, int valeur)
    {
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSup : addValue : index invalide : " + hauteur + ", " + largeur);
        }

        values_array[hauteur * taille + largeur - exp(hauteur) - hauteur - 1] = valeur;
    }

    /**
     * Affiche la partie superieure de la matrice.
     */
    protected void display()
    {
        int hauteur = 0;
        int i = 0;
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
            i++;

            if(i + hauteur >= taille - 1)
            {
                System.out.println();
                hauteur++;
                i = 0;
            }
        }
    }
}