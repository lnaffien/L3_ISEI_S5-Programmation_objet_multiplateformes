/***********************************************************************************************************************************************

                                                                MatriceDense
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

import java.util.ArrayList;
import java.util.Scanner;

public class MatriceDense implements Matrice
{
    int max_hauteur;
    int max_largeur;
    ArrayList<ArrayList<Integer>> matrice;

    public MatriceDense(int taille)
    {
        this.max_hauteur = taille;
        this.max_largeur = taille;
        matrice = new ArrayList<ArrayList<Integer>>();
        initMatrice();
    }

    public void modifierValeur(int x, int y, int valeur)
    {
        if((x >= 0 && x < this.max_hauteur) && (y >= 0 && y < this.max_largeur))
        {
            int index_doublon = existeDeja(x, y);
            if(index_doublon != -1)
            {
                matrice.get(index_doublon).set(2, valeur);
            }
            else
            {
                ArrayList<Integer> ligne = new ArrayList<Integer>();
                ligne.add(x);
                ligne.add(y);
                ligne.add(valeur);
                matrice.add(ligne);
            }            
        }
    }

    /* existe
     */
    private int existeDeja(int x, int y)
    {
        for(ArrayList<Integer> ligne : matrice)
        {
            if(ligne.get(0) == x && ligne.get(1) == y)
            {
                return matrice.indexOf(ligne);
            }
        }
        return -1;
    }

    public void initMatrice()
    {
        System.out.println("Veuillez indiquer les cases non nulles de la matrice sous la forme suivante : x(hauteur) y(largeur) valeur");
        System.out.println("Exemple :\n0 0 5");
        System.out.println("Attention : une case deja enregistree sera reecrite.");

        Scanner in = new Scanner(System.in);
        int fin = 1;
        while(fin != 0)
        {
            System.out.println("Nouvelle valeur : ");
            modifierValeur(in.nextInt(), in.nextInt(), in.nextInt());

            System.out.println("Continuer ?");
            System.out.println("0 : non");
            System.out.println("1 : oui");
            fin = in.nextInt();
        }
        System.out.println("Fin de l'entree des donnees.\n");
        in.close();
    }

    public void afficherMatrice()
    {
        System.out.println("Matrice dense :");
        System.out.println(matrice.toString());
    }
    
}