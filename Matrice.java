/***********************************************************************************************************************************************

                                                                Matrice
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

import java.util.Scanner;

public abstract class Matrice
{
    int hauteur;
    int largeur;    
    int matrice[][];
    Scanner in;

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    public Matrice(int taille)
    {
        if(taille <= 0)
        {
            throw new ArithmeticException("Taille invalide");
        }

        this.hauteur = taille;
        this.largeur = taille;
        in = new Scanner(System.in);
        matrice = new int[this.hauteur][this.largeur];
    }

    public Matrice(Matrice m)
    {
        if(m == null)
        {
            throw new ArithmeticException("Cette matrice lineaire n'existe pas.");
        }

        this.hauteur = m.hauteur;
        this.largeur = m.largeur;
        matrice = new int[this.hauteur][this.largeur];
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    public void afficherMatrice()
    {        
        System.out.println(this.getClass() + " :");
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

    protected void initMatrice()
    {
        System.out.println("Veuillez indiquer les cases non nulles de la matrice sous la forme suivante : x(hauteur) y(largeur) valeur");
        System.out.println("Attention : une case deja enregistree sera reecrite.");
        System.out.println("Exemple :\n0 0 5");

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

    protected void initMatrice(Matrice m)
    {
        for(int i = 0; i < this.hauteur; i++)
        {
            for(int j = 0; j < this.largeur; j++)
            {
                /* Si la valeur vaut 0, celle-ci n'est pas ecrite dans la matrice grace aux lignes commentees ci-dessous.
                 * Si la matrice contient de nombreuses valeurs non nulles, elles rajoutent cependant un certain temps d'execution.
                 * A decommenter donc en fonction des cas. */
                // if(m.matrice[i][j] != 0)
                // {
                    this.matrice[i][j] = m.matrice[i][j];
                // }
            }
        }
    }

    

}
