/***********************************************************************************************************************************************

                                                                MatriceDense
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

************************************************************************************************************************************************/

import java.util.ArrayList;

public class MatriceDense extends Matrice
{
    ArrayList<ArrayList<Integer>> matrice_dense_liste;
    int matrice_dense_tab[][];

   /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice carree
     */
    public MatriceDense(int taille)
    {
        super(taille);
        matrice_dense_liste = new ArrayList<ArrayList<Integer>>();
        initMatrice();

        arrayListToArrayFormeLineaire();
        arrayListToArrayFormeDense();
    }

    /**
     * Constructeur : creation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    public MatriceDense(Matrice m)
    {
        super(m);
        matrice_dense_liste = new ArrayList<ArrayList<Integer>>();
        initMatrice(m);
        arrayListToArrayFormeDense();
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    @Override
    public void modifierValeur(int x, int y, int valeur)
    {
        if((x >= 0 && x < this.hauteur) && (y >= 0 && y < this.largeur))
        {
            int index_doublon = existeDeja(x, y);
            if(index_doublon != -1)
            {
                matrice_dense_liste.get(index_doublon).set(2, valeur);
            }
            else
            {
                ArrayList<Integer> ligne = new ArrayList<Integer>();
                ligne.add(x);
                ligne.add(y);
                ligne.add(valeur);
                matrice_dense_liste.add(ligne);
            }            
        }
        else
        {
            System.out.println("Valeurs non valides.\n");
        }
    }

    /**
     * Verifie qu'aucune valeur n'a deja ete enregistree a l'index de la matrice donne.
     * @param x position dans la hauteur de la matrice
     * @param y position dans la hauteur de la matrice
     * @return -1 si 
     */
    private int existeDeja(int x, int y)
    {
        for(ArrayList<Integer> ligne : matrice_dense_liste)
        {
            if(ligne.get(0) == x && ligne.get(1) == y)
            {
                return matrice_dense_liste.indexOf(ligne);
            }
        }
        return -1;
    }    

    public void arrayListToArrayFormeLineaire()
    {
        for (ArrayList<Integer> ligne : matrice_dense_liste)
        {
            matrice[ligne.get(0)][ligne.get(1)] = ligne.get(2);
        }
    }

    public void arrayListToArrayFormeDense()
    {
        matrice_dense_tab = new int[this.matrice_dense_liste.size()][3];
        int cursor = 0;
        for(ArrayList<Integer> ligne : this.matrice_dense_liste)
        {
            matrice_dense_tab[cursor][0] = ligne.get(0);
            matrice_dense_tab[cursor][1] = ligne.get(1);
            matrice_dense_tab[cursor][2] = ligne.get(2);
            cursor ++;
        }
    }

    public void afficherMatriceListe()
    {
        System.out.println(this.getClass() + " (liste) :");
        System.out.println(matrice_dense_liste.toString());
    }

    public void afficherMatriceDense()
    {
        System.out.println(this.getClass() + " (forme dense) :");
        for(int i = 0; i < matrice_dense_tab.length; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                System.out.print(this.matrice_dense_tab[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
}