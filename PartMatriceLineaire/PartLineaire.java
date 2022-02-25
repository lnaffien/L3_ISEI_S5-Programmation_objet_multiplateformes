/***********************************************************************************************************************************************

                                                                PartLineaire
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package PartMatriceLineaire;

abstract class PartLineaire
{    
    int values_array[];     // Tableau contenant les valeurs de la partie superieure de la matrice de facon lineaire.
    int taille;             // Taille de la matrice carree

    protected PartLineaire(int taille)
    {
        this.taille = taille;
    }

    /**
     * Calcule l'exponentielle d'une valeur donnee.
     * @param val valeur dont on veut connaitre l'exponentielle
     * @return exponentielle de la valeur donnee
     */
    protected int exp(int val)
    {
        int res = val;
        if(val > 0)
        {
            res += exp(val - 1);
        }
        return res;
    }

    /**
     * Retourne les valeurs de la diagonale de la matrice.
     * @return valeurs de la diagonale de la matrice
     */
    public int[] get()
    {
        return this.values_array;
    }

}
