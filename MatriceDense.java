/***********************************************************************************************************************************************

                                                                MatriceDense
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

import java.util.ArrayList;

public class MatriceDense extends Matrice
{
    /*************************************************
     * 
     *              Variables globales
     * 
     *************************************************/

    ArrayList<ArrayList<Integer>> matrice_dense_liste;  // ArrayList contenant les donnees de la matrice dense.
                                                        // Permet une flexibilite sur le nombre de donnees, 
                                                        // mais prend plus d'espace memoire qu'un tableau 2D.
    int matrice_dense_tab[][];                          // Tableau 2D contenant les donnees de la matrice dense.
                                                        // Taille fixe  en echange d'un espace memoire optimise. 

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

        // Initialisation de tableaux 2D contenant la matrice sous differentes formes : lineaire et dense.
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

        // Initialisation de tableaux 2D contenant la matrice sous differentes formes : lineaire et dense.
        arrayListToArrayFormeLineaire();
        arrayListToArrayFormeDense();
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /** 
     * Modifie une valeur non nulle a une position donnee dans la matrice.
     * Si une donnee a deja ete entree a cette position, la remplace.
     * Si une donnee a deje ete entree a cette position et que la valeur est nulle, suppression des donnees concernant cette position.
     * 
     * @param x position dans la hauteur de la matrice
     * @param y position dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    @Override
    public void modifierValeur(int x, int y, int valeur)
    {
        // Verification que la position donnee est valide. Le cas contraire, affiche un message d'erreur.
        if((x >= 0 && x < this.hauteur) && (y >= 0 && y < this.largeur))
        {
            // Verification si un donnee a deja ete enregistree a cet index.
            int index_doublon = existeDeja(x, y);
            if(index_doublon != -1)
            {
                // Modification de la valeur si elle ne vaut pas 0.
                if(valeur != 0)
                {
                    matrice_dense_liste.get(index_doublon).set(2, valeur);
                }
                // Suppression des donnees si la valeur vaut 0.
                else
                {
                    matrice_dense_liste.remove(index_doublon);
                }
            }
            else
            {
                // Ajout des donnees dans la liste si la valeur ne vaut pas 0.
                if(valeur != 0)
                {
                    ArrayList<Integer> ligne = new ArrayList<Integer>();
                    ligne.add(x);
                    ligne.add(y);
                    ligne.add(valeur);
                    matrice_dense_liste.add(ligne);
                }                
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
     * @param y position dans la largeur de la matrice
     * @return -1 si aucune valeur n'a ete enregistree a ces index, index de ces donnees dans l'ArrayList sinon
     */
    private int existeDeja(int x, int y)
    {
        for(ArrayList<Integer> ligne : matrice_dense_liste)
        {
            // Si ce couple de position existe deja dans l'ArrayList, renvoie de la position de ce couple.
            if(ligne.get(0) == x && ligne.get(1) == y)
            {
                return matrice_dense_liste.indexOf(ligne);
            }
        }
        return -1;
    }    

    /**
     * Initialise un tableau 2D de int contenant la matrice dense sous sa forme lineaire a partir de l'ArrayList.
     */
    private void arrayListToArrayFormeLineaire()
    {
        for (ArrayList<Integer> ligne : matrice_dense_liste)
        {
            matrice[ligne.get(0)][ligne.get(1)] = ligne.get(2);
        }
    }

    /**
     * Initialise un tableau 2D de int contenant la matrice dense sous sa forme dense a partir de l'ArrayList.
     */
    private void arrayListToArrayFormeDense()
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

    /**
     * Affiche la matrice sous sa forme dense en utilisant les proprietes d'ArrayList.
     */
    public void afficherMatriceListe()
    {
        System.out.println(this.getClass() + " (liste) :");
        System.out.println(matrice_dense_liste.toString());
    }

    /**
     * Affiche la matrice sous sa forme dense en utilisant un tableau 2D genere a partir de l'ArrayList.
     */
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