/***********************************************************************************************************************************************

                                                                Matrice
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/
package v1;
import java.util.Scanner;

public abstract class Matrice
{
    /*************************************************
     * 
     *              Variables globales
     * 
     *************************************************/

    int hauteur;        // Hauteur maximale de la matrice.
    int largeur;        // Largeur maximale de la matrice.
    int matrice[][];    // Tableau 2D contenant la matrice sous sa forme lineaire.
    Scanner in;         // Flux d'entrees standard pour les entrees clavier de l'utilisateur.

    /*************************************************
     * 
     *              Constructeurs
     * 
     *************************************************/

    /**
     * Constructeur.
     * @param taille taille de la matrice carree
     */
    public Matrice(int taille)
    {
        // Verification de la validite de la taille donnee.
        if(taille <= 0)
        {
            throw new ArithmeticException("Taille invalide");
        }

        // Initialisation des variables globales.
        this.hauteur = taille;
        this.largeur = taille;
        in = new Scanner(System.in);
        matrice = new int[this.hauteur][this.largeur];
    }

    /**
     * Constructeur : creation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    public Matrice(Matrice m)
    {
        // Verification de la validite de la matrice donnee.
        if(m == null)
        {
            throw new ArithmeticException("Cette matrice lineaire n'existe pas.");
        }

        // Initialisation des variables globales. La variable in n'etant pas utilisee, elle n'est pas initialisee.
        this.hauteur = m.hauteur;
        this.largeur = m.largeur;
        matrice = new int[this.hauteur][this.largeur];
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/

    /**
     * Affiche la matrice sous sa forme lineaire.
     */
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
    
    /** 
     * Modifie une valeur a une position donnee dans la matrice.
     * @param x position dans la hauteur de la matrice
     * @param y position dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    public void modifierValeur(int x, int y, int valeur)
    {
        // Verification de la validite des index donnes.
        if((x >= 0 && x < this.hauteur) && (y >= 0 && y < this.largeur))
        {
            this.matrice[x][y] = valeur;
        }
        else
        {
            System.out.println("Valeur(s) non valide(s).\n");
        }
    } 

    /**
     * Initialisation manuelle de la matrice.
     */
    protected void initMatrice()
    {
        System.out.println("Veuillez indiquer les cases non nulles de la matrice sous la forme suivante : x(hauteur) y(largeur) valeur");
        System.out.println("Attention : une case deja enregistree sera reecrite.");
        System.out.println("Exemple :\n0 0 5");

        int fin = 1;
        while(fin != 0)
        {
            // Ajout d'une nouvelle valeur en fonction de l'entree renseignee.
            System.out.println("Nouvelle valeur : ");
            modifierValeur(in.nextInt(), in.nextInt(), in.nextInt());

            // Verification que l'utilisateur veuille continuer ou non.
            System.out.println("Continuer ?");
            System.out.println("0 : non");
            System.out.println("1 : oui");
            fin = in.nextInt();
        }

        System.out.println("Fin de l'entree des donnees.\n");

        // Fermeture du Scanner afin d'eviter des fuites de memoire.
        in.close();
    }

    
    /** 
     * Initialisation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    protected void initMatrice(Matrice m)
    {
        for(int i = 0; i < this.hauteur; i++)
        {
            for(int j = 0; j < this.largeur; j++)
            {
                // Ajout d'une valeur si celle-ci est differente de 0.
                if(m.matrice[i][j] != 0)
                {
                    modifierValeur(i, j, m.matrice[i][j]);
                }
            }
        }
    }

    /*************************************************
     *          Calculs matriciels
     *************************************************/

    /**
     * Additionne la matrice actuelle et celle donnee en parametres.
     * @param m matrice a additionner
     * @return matrice resultat de l'addition
     */
    public MatriceCreuse additionnerMatrice(Matrice m)
    {
        // Verification que les 2 matrices soient bien additionnables.
        if(this.largeur != m.largeur || this.hauteur != m.hauteur)
        {
            throw new ArithmeticException("Les 2 matrices a additionner sont de tailles differentes.");
        }

        // Declaration d'une matrice resultat.
        MatriceCreuse matrice_resultat = new MatriceCreuse(m);

        // Stockage du resultat dans la matrice resultat.
        for(int i = 0; i < this.hauteur; i ++)
        {
            for(int j = 0; j < this.largeur; j++)
            {
                matrice_resultat.matrice[i][j] += this.matrice[i][j];
            }
        }
        return matrice_resultat;
    }

    /**
     * Multiplie la matrice actuelle par celle donnee en parametres.
     * @param m matrice multiplicative
     * @return matrice resultat de la multiplication
     */
    public MatriceCreuse multiplierMatrice(Matrice m)
    {
        // Verification que les 2 matrices peuvent bien être multipliées.
        if(this.largeur != m.hauteur || this.hauteur != m.largeur)
        {
            throw new ArithmeticException("Les 2 matrices a multiplier n'ont pas des tailles compatibles.");
        }

        // Declaration d'une matrice resultat.
        MatriceCreuse matrice_resultat = new MatriceCreuse(m);
        int somme;

        // Stockage du resultat dans la matrice resultat.
        for(int i = 0; i < this.hauteur; i++)
        {
            for(int j = 0; j < m.largeur; j++)
            {                
                somme = 0;

                for(int k = 0; k < this.largeur; k ++)
                {
                   somme += this.matrice[i][k] * m.matrice[k][j];
                }
                matrice_resultat.modifierValeur(i, j, somme);
            }            
        }

        return matrice_resultat;
    }
    

}
