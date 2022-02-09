package PartMatrice;

public class PartDiagonal
{
    private int values_array[]; // Tableau contenant les valeurs de la diagonale de la matrice de facon lineaire.
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
    public PartDiagonal(int taille)
    {
        this.taille = taille;
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
    public int getValueFromIndex(int index)
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
    public void addValue(int index, int valeur)
    {
        if(index >= taille || index < 0)
        {
            throw new ArithmeticException("PartDiagonal : addValue : index invalide");
        }
        values_array[index] = valeur;
    }

    /**
     * Retourne les valeurs de la diagonale de la matrice.
     * @return valeurs de la diagonale de la matrice
     */
    public int[] getDiagonal()
    {
        return this.values_array;
    }

    /**
     * Affiche la diagonale de la matrice.
     */
    public void display()
    {
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
        }
        System.out.println();
    }
}
