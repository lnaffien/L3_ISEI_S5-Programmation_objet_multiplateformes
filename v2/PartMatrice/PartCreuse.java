package PartMatrice;

public class PartCreuse
{
    public int values_array[][];                // Tableau 2D contenant les valeurs de la partie de la matrice de facon dense.
    final int VALUES_ARRAY_NBR_COLONNES = 2;    // Nombre de colonnes du tableau de donnees.
    final int VALUES_ARRAY_OFFSET = 0;          // Position de l'offset dans le tableau.
    final int VALUES_ARRAY_VALUE = 1;           // Position de la valeur dans le tableau.

    int taille;                                 // Taille de la matrice carree.

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice caree
     */
    public PartCreuse(int taille)
    {
        this.taille = taille;
        this.values_array = new int[0][VALUES_ARRAY_NBR_COLONNES];
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/
    
    /**
     * Copie un tableau 2D donne dans un autre.
     * Les 2 tableaux peuvent etre de taille differente. Dans ce cas, la copie s'arretera une fois cette taille depassee.
     * 
     * @param array_initial tableau a copier
     * @param array_final tableau dont on veut modifier les valeurs a partir du tableau initial
     */
    public void copyArray(int[][] array_initial, int[][] array_final)
    {
        int taille_min = array_initial.length < array_final.length ? array_initial.length : array_final.length;

        for(int i = 0; i < taille_min; i++)
        {
            for(int j = 0; j < VALUES_ARRAY_NBR_COLONNES; j++)
            {
                array_final[i][j] = array_initial[i][j];
            }
        }
    }

    /**
     * Retourne les valeurs de la partie de la matrice.
     * @return valeurs de la partie de la matrice
     */
    public int[][] getPart()
    {
        return this.values_array;
    }

    /**
     * Affiche la partie de la matrice.
     */
    public void display()
    {
        for(int i = 0; i < values_array.length; i++)
        {
            System.out.println("[" + values_array[i][VALUES_ARRAY_OFFSET] + ", " + values_array[i][VALUES_ARRAY_VALUE] + "] ");
        }
    }

    public int getOffset(int hauteur, int largeur)
    {
        return hauteur * taille + largeur;
    }

    public int getHauteur(int offset)
    {
        return offset / taille; //(ou offset / (taille + 1) ?)
    }

    public int getLargeur(int offset)
    {
        return offset % taille;
    }

    /*
 * offset = hauteur * taille + largeur
 *      offset - largeur = hauteur * taille *      
 * hauteur = (offset - largeur) / taille
 *      - largeur = hauteur * taille - offset
 * largeur = - (hauteur * taille - offset)
 * 
 * hauteur / taille
 * 
 * offset = x * taille + x
 * offset - x = x * taille
 * (offset - x) / x = taille
 * offset / x - x / x = taille
 * offset / x - 1 = taille
 * offset / x = taille + 1
 * offset = (taille + 1) * x
 * offset / (taille + 1) = x
 */ 
    
}
