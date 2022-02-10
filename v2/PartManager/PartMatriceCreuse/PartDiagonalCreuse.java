package PartManager.PartMatriceCreuse;

class PartDiagonalCreuse extends PartCreuse
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
    protected PartDiagonalCreuse(int taille)
    {
        super(taille);
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
            throw new ArithmeticException("PartDiagonalCreuse : getValueFromIndex : index invalide.");
        }

        // Calcul de l'offset de l'index donne.
        int offset = getOffset(index, index);

        // Recherche de l'index dans le tableau des donnees.
        for(int i = 0; i < values_array.length; i++)
        {
            if(values_array[i][VALUES_ARRAY_OFFSET] == offset)
            {
                return values_array[i][VALUES_ARRAY_VALUE];
            }
        }

        // La valeur vaut 0 si elle n'a pas ete stockee dans le tableau de donnees.
        return 0;
    }

    /**
     * Modifie une valeur a une position donnee dans la matrice.
     * @param index position dans la hauteur et dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    protected void ajouterValeur(int index, int valeur)
    {
        // Verification de la validite de l'index
        if(index >= taille || index < 0)
        {
            throw new ArithmeticException("PartDiagonalCreuse : addValue : index invalide");
        }        
        
        int existe = existeDeja(index);

        // Si une valeur a deja ete enregistree a l'index donne.
        if(existe >= 0)
        {
            if(valeur == 0)
            {
                supprimerValeur(index);
            }
            else
            {
                values_array[existe][VALUES_ARRAY_VALUE] = valeur;
            }
        }
        // Ajout de la donnee si elle est differente de 0.
        else if(valeur != 0)
        {
            int[][] temp_array = values_array;
            values_array = new int[values_array.length + 1][VALUES_ARRAY_NBR_COLONNES];
            copyArray(temp_array, values_array);
            values_array[values_array.length - 1][VALUES_ARRAY_VALUE] = valeur;
            values_array[values_array.length - 1][VALUES_ARRAY_OFFSET] = getOffset(index, index);
        }
    }

    /**
     * Verifie qu'aucune valeur n'a deja ete enregistree a l'index de la matrice donne.
     * @param index position dans la hauteur et dans la largeur de la matrice
     * @return -1 si aucune valeur n'a ete enregistree a ces index, index de ces donnees dans le tableau
     */
    private int existeDeja(int index)
    {
        for(int i = 0; i < values_array.length; i++)
        {
            if(values_array[i][VALUES_ARRAY_OFFSET] == getOffset(index, index))
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Supprime la valeur a un index donne.
     * @param index index dont on veut supprimer la valeur
     */
    protected void supprimerValeur(int index)
    {
        int offset = getOffset(index, index);
        int temp_array[][] = values_array;
        values_array = new int[temp_array.length - 1][VALUES_ARRAY_NBR_COLONNES];        

        int iterateur = 0;
        for(int i = 0; i < temp_array.length; i++)
        {
            if(temp_array[i][VALUES_ARRAY_OFFSET] == offset)
            {
                iterateur ++;
            }
            else
            {
                for(int j = 0; j < VALUES_ARRAY_NBR_COLONNES; j++)
                {
                    values_array[i - iterateur][j] = temp_array[i][j];
                }
            }                    
        }
    }


    
}


