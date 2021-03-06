/***********************************************************************************************************************************************

                                                                PartSupCreuse
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

package PartMatriceCreuse;

class PartSupCreuse extends PartCreuse
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
    protected PartSupCreuse(int taille)
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
    protected int getValueFromIndex(int hauteur, int largeur)
    {
        // Verification de la validite des index donnes.
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSupCreuse : getValueFromIndex : index invalide.");
        }

        // Calcul de l'offset de l'index donne.
        int offset = getOffset(hauteur, largeur);

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
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    protected void ajouterValeur(int hauteur, int largeur, int valeur)
    {
        // Verification de la validite de l'index
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSupCreuse : addValue : coordonnees invalides");
        }        
        
        int existe = existeDeja(hauteur, largeur);

        // Si une valeur a deja ete enregistree a l'index donne.
        if(existe >= 0)
        {
            if(valeur == 0)
            {
                supprimerValeur(hauteur, largeur);
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
            values_array[values_array.length - 1][VALUES_ARRAY_OFFSET] = getOffset(hauteur, largeur);
        }
    }

    /**
     * Verifie qu'aucune valeur n'a deja ete enregistree a l'index de la matrice donne.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @return -1 si aucune valeur n'a ete enregistree a ces index, index de ces donnees dans le tableau
     */
    private int existeDeja(int hauteur, int largeur)
    {
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSupCreuse : existeDeja : coordonnees invalides");
        }
        int offset = getOffset(hauteur, largeur);
        for(int i = 0; i < values_array.length; i++)
        {
            if(values_array[i][VALUES_ARRAY_OFFSET] == offset)
            {
                return i;
            }
        }
        return -1;
    }

    /**
     * Supprime la valeur aux coordonnees donnees.
     * @param hauteur coordonnee de la hauteur dont on veut supprimer la valeur
     * @param largeur coordonnee de la largeur dont on veut supprimer la valeur
     */
    protected void supprimerValeur(int hauteur, int largeur)
    {
        if(hauteur < 0 || hauteur >= taille - 1 || largeur <= 0 || largeur >= taille || hauteur > largeur)
        {
            throw new ArithmeticException("PartSupCreuse : supprimerValeur : coordonnees invalides");
        }

        int offset = getOffset(hauteur, largeur);
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
