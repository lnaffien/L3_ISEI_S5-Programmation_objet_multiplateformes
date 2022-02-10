import java.util.Scanner;

import Matrice.Matrice;
import Matrice.MatriceCreuse;
import Matrice.MatriceLineaire;

/* A ajouter : 
 * - Calcul de la matrice transposée (= échange des indices (ex : 2 3 5 et 3 2 9. Il faut avoir 2 3 9 et 3 2 5.). Tres rapide pour la matrice creuse)
 * 
 * Notes : La matrice que j'ai nommee dense est en réalité une matrice creuse. Mais du coup c'est quoi une matrice dense ?
 */

public class Main
{
    public static void main(String arg[])
    {
        // Declaration des variables locales.
        Matrice matrice;
        MatriceLineaire ml;
        MatriceCreuse mc;
        int taille;
        int type = 0;
        Scanner in = new Scanner(System.in);

        /******************
         * Initialisation *
         ******************/
        System.out.println("Bonjour ! Je suis un createur de matrices carrees, pour vous servir !");

        // Taille de la matrice.
        System.out.println("Quelle est la taille de la matrice ? ");
        taille = in.nextInt();
        if(taille <= 0)
        {
            in.close();
            throw new ArithmeticException("Taille invalide, veuillez relancer le programme.");
        }
        
        // Type initial de la matrice.
        System.out.println("Quel est son type initial ?");
        System.out.println("1 : matrice lineaire");
        System.out.println("2 : matrice creuse");
        type = in.nextInt();

        // Initialisation de la matrice en fonction des informations donnees.
        switch(type)
        {
            // Matrice lineaire
            case 1 : 
                ml = new MatriceLineaire(taille);
                matrice = ml;

            //     mc = new MatriceCreuse(matrice);
            //     mc.afficherMatrice();

            //     md = new MatriceDense(matrice);
            //     md.afficherMatrice();
            //     md.afficherMatriceDense();

                break;

            // Matrice creuse
            case 2 :
                mc = new MatriceCreuse(taille);
                mc.afficherPartMatrice();                
                matrice = mc;

                ml = new MatriceLineaire(matrice);
                ml.afficherPartMatrice();

                // md = new MatriceDense(matrice);
                // md.afficherMatrice();
                // md.afficherMatriceDense();

                break;

            // Erreur
            default : 
                in.close();
                throw new ArithmeticException("Type de matrice invalide, veuillez relancer le programme.");
        }
        
        // Fermeture du Scanner afin d'eviter des fuites de memoire
        in.close();

        
    }
}
