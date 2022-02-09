package PartMatrice;

public class PartSup
{
    private int values_array[]; // Tableau contenant les valeurs de la partie superieure de la matrice de facon lineaire.
    int taille;                   // Taille de la matrice carree.

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice caree
     */
    public PartSup(int taille)
    {
        this.taille = taille;
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
    public int getValueFromIndex(int hauteur, int largeur)
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
    public void addValue(int hauteur, int largeur, int valeur)
    {
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSup : addValue : index invalide : " + hauteur + ", " + largeur);
        }

        values_array[hauteur * taille + largeur - exp(hauteur) - hauteur - 1] = valeur;
    }

    /**
     * Calcule l'exponentielle d'une valeur donnee.
     * @param val valeur dont on veut connaitre l'exponentielle
     * @return exponentielle de la valeur donnee
     */
    private int exp(int val)
    {
        int res = val;
        if(val > 0)
        {
            res += exp(val - 1);
        }
        return res;
    }

    /**
     * Retourne les valeurs de la partie superieure de la matrice.
     * @return valeurs de la partie superieure de la matrice
     */
    public int[] getPartSup()
    {
        return this.values_array;
    }

    /**
     * Affiche la partie superieure de la matrice.
     */
    public void display()
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