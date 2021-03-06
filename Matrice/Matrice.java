/***********************************************************************************************************************************************

                                                                Matrice
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/
package Matrice;
import java.util.Scanner;

public abstract class Matrice
{
    /*************************************************
     * 
     *              Variables globales
     * 
     *************************************************/

    int taille;                 // Taille de la matrice carree.
    protected Scanner in;       // Flux d'entrees standard pour les entrees clavier de l'utilisateur.
    PartManager partManager;    // Manager pour gerer les 3 parties de la matrice (diagonale, partie inferieure et partie superieure).

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
        this.taille = taille;
        in = new Scanner(System.in);
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
        this.taille = m.taille;
    }

    /*************************************************
     * 
     *              Methodes
     * 
     *************************************************/
    
    /** 
     * Initialisation de la matrice a partir d'une autre.
     * @param m matrice initiale
     */
    protected void initMatrice(Matrice m)
    {
        for(int i = 0; i < this.taille; i++)
        {
            for(int j = 0; j < this.taille; j++)
            {
                // Ajout d'une valeur si celle-ci est differente de 0.
                int valeur = m.partManager.getValueFromIndex(i, j);
                if( valeur != 0)
                {
                    modifierValeur(i, j, valeur);
                }
            }
        }
    }
    
    /** 
     * Modifie une valeur a une position donnee dans la matrice.
     * @param hauteur position dans la hauteur de la matrice
     * @param largeur position dans la largeur de la matrice
     * @param valeur nouvelle valeur a ajouter
     */
    public void modifierValeur(int hauteur, int largeur, int valeur)
    {
        this.partManager.ajouterValeur(hauteur, largeur, valeur);
    }

    /**
     * Affiche la matrice telle qu'elle est stockee.
     */
    public void afficherPartMatrice()
    {
        partManager.afficherPartMatrice();
    }
    
    /**
     * Affiche la matrice sous sa forme lineaire.
     */
    public void afficherMatriceFormeLineaire()
    {        
        System.out.println(this.getClass() + " :");
        for(int i = 0; i < this.taille; i++)
        {
            for(int j = 0; j < this.taille; j++)
            {
                System.out.print(this.partManager.getValueFromIndex(i, j) + " | ");
            }
            System.out.println();
        }
        System.out.println();
    }

    /*************************************************
     *          Calculs matriciels
     *************************************************/

    /**
     * Additionne la matrice actuelle et celle donnee en parametres.
     * @param m matrice a additionner
     * @return matrice resultat de l'addition
     */
    public Matrice additionnerMatrice(Matrice addition, Matrice resultat)
    {
        // Verification que les 2 matrices soient bien additionnables.
        if(this.taille != addition.taille || this.taille != resultat.taille)
        {
            throw new ArithmeticException("Matrice : additionnerMatrice : addition impossible, car les matrices sont de tailles differentes");
        }

        // Stockage du resultat dans la matrice resultat.
        for(int i = 0; i < this.taille; i ++)
        {
            for(int j = 0; j < this.taille; j++)
            {
                resultat.partManager.ajouterValeur(i, j, addition.partManager.getValueFromIndex(i, j) + this.partManager.getValueFromIndex(i, j));
                //matrice_resultat.matrice[i][j] += this.matrice[i][j];
            }
        }
        return resultat;
    }

    /**
     * Multiplie la matrice actuelle par celle donnee en parametres.
     * @param m matrice multiplicative
     * @return matrice resultat de la multiplication
     */
    public Matrice multiplierMatrice(Matrice multiplication, Matrice resultat)
    {
        // Verification que les 2 matrices peuvent bien ??tre multipli??es.
        if(this.taille != multiplication.taille || this.taille != resultat.taille)
        {
            throw new ArithmeticException("Matrice : multiplierMatrice : multiplication impossible, car les matrices n'ont pas des tailles compatibles");
        }        

        // Stockage du resultat dans la matrice resultat.
        int somme;
        for(int i = 0; i < this.taille; i++)
        {
            for(int j = 0; j < multiplication.taille; j++)
            {                
                somme = 0;

                for(int k = 0; k < this.taille; k ++)
                {
                    somme += this.partManager.getValueFromIndex(i, k) * multiplication.partManager.getValueFromIndex(k, j);
                   // somme += this.matrice[i][k] * m.matrice[k][j];
                }
                resultat.modifierValeur(i, j, somme);
            }            
        }

        return resultat;
    }

    /**
     * Transpose la matrice donnee en parametres.
     * @param transpose matrice a transposer
     * @return matrice resultat de la transposition
     */
    public Matrice transposer(Matrice transpose)
    {
        transpose.partManager.transposer();        
        return transpose;
    }    

}
