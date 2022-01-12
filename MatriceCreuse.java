/***********************************************************************************************************************************************

                                                                MatriceCreuse
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

import java.util.Scanner;

public class MatriceCreuse implements Matrice
{
    int hauteur;
    int largeur;
    int matrice[][];

    public MatriceCreuse(int taille)
    {
        this.hauteur = taille;
        this.largeur = taille;
        matrice = new int[this.hauteur][this.largeur];
        initMatrice();
    }

    public MatriceCreuse(MatriceLineaire ml)
    {
        if(ml == null)
        {
            throw new ArithmeticException("Cette matrice lineaire n'existe pas.");
        }
        this.hauteur = ml.hauteur;
        this.largeur = ml.largeur;
        matrice = new int[this.hauteur][this.largeur];
        initDiagonale(ml);
        initInf(ml);
        initSup(ml);
    }

    public void afficherMatrice()
    {
        System.out.println("Matrice creuse :");
        for(int i = 0; i < this.hauteur; i++)
        {
            for(int j = 0; j < this.largeur; j++)
            {
                System.out.print(this.matrice[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void modifierValeur(int x, int y, int valeur)
    {
        if((x >= 0 && x < this.hauteur) && (y >= 0 && y < this.largeur))
        {
            this.matrice[x][y] = valeur;
            System.out.println("Valeur modifiee.\n");
        }
        else
        {
            System.out.println("Valeurs non valides.\n");
        }
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
    
    public void initDiagonale(MatriceLineaire ml)
    {
        int i = 0;
        int j = 0;
        while(i < this.hauteur && j < this.largeur)
        {
            if(ml.matrice[i][j] != 0)
            {
                this.matrice[i][j] = ml.matrice[i][j];
            }
            i++;
            j++;
        }
    }

    public void initInf(MatriceLineaire ml)
    {
        int h_cursor = 1;
        int w_cursor = 0;
        int diagonale = 0;

        while(h_cursor < this.hauteur)
        {
            if(ml.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = ml.matrice[h_cursor][w_cursor];
            }
            w_cursor ++;

            if(w_cursor > diagonale || w_cursor >= this.largeur)
            {
                w_cursor = 0;
                h_cursor ++;
                diagonale ++;
            }
        }
    }

    public void initSup(MatriceLineaire ml)
    {
        int h_cursor = 0;
        int w_cursor = 1;
        int diagonale = 0;

        while(h_cursor < this.hauteur && w_cursor < this.largeur)
        {
            if(ml.matrice[h_cursor][w_cursor] != 0)
            {
                this.matrice[h_cursor][w_cursor] = ml.matrice[h_cursor][w_cursor];
            }
            w_cursor ++;

            if(w_cursor >= this.largeur)
            {
                diagonale ++;
                w_cursor = diagonale + 1;
                h_cursor ++;
            }
        }

    }
}