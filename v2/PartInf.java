public class PartInf
{
    private int values_array[]; // Tableau contenant les valeurs de la partie superieure de la matrice de facon lineaire.
    int size;                   // Taille de la matrice carree.

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param size taille de la matrice caree
     */
    public PartInf(int size)
    {
        this.size = size;
        values_array = new int[((size * size) - size) / 2];
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Retourne la valeur stockee a une position donnee dans la matrice.
     * @param x position dans la hauteur de la matrice
     * @param y position dans la largeur de la matrice
     * @return valeur stockee a la position donnee
     */
    public int getValueFromIndex(int x, int y)
    {
        if(x <= 0 || x >= size || y < 0 || y >= size - 1)
        {
            throw new ArithmeticException("PartInf : getValueFromIndex : index invalide :"  + x + ", " + y);
        }
        return values_array[y + exp(x - 1)];
    }

    /**
     * Modifie une valeur a une position donnee dans la matrice.
     * @param x position dans la hauteur de la matrice
     * @param y position dans la largeur de la matrice
     * @param value nouvelle valeur a ajouter
     */
    public void addValue(int x, int y, int valeur)
    {
        if(x <= 0 || x >= size || y < 0 || y >= size - 1 || x < y)
        {
            throw new ArithmeticException("PartInf : addValue : index invalide : " + x + ", " + y);
        }

        values_array[y + exp(x - 1)] = valeur;
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
     * Retourne les valeurs de la partie inferieure de la matrice.
     * @return valeurs de la partie inferieure de la matrice
     */
    public int[] getPartInf()
    {
        return this.values_array;
    }

    /**
     * Affiche la partie inferieure de la matrice.
     */
    public void display()
    {
        int hauteur = 1;
        int i = 0;
        for (int value : values_array)
        {
            System.out.print(value + " ; ");
            i++;

            if(i >= hauteur)
            {
                System.out.println();
                hauteur++;
                i = 0;
            }
        }
    }
}