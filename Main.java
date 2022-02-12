import java.util.Scanner;

import Matrice.Matrice;
import Matrice.MatriceCreuse;
import Matrice.MatriceLineaire;

/* A ajouter : 
 * - Calcul de la matrice transposée (= échange des indices (ex : 2 3 5 et 3 2 9. Il faut avoir 2 3 9 et 3 2 5.). Tres rapide pour la matrice creuse)
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

                mc = new MatriceCreuse(matrice);
                mc.afficherPartMatrice();
                mc.afficherMatriceFormeLineaire();

                break;

            // Matrice creuse
            case 2 :
                mc = new MatriceCreuse(taille);
                mc.afficherPartMatrice();  
                mc.afficherMatriceFormeLineaire();              
                matrice = mc;

                ml = new MatriceLineaire(matrice);
                ml.afficherPartMatrice();

                break;

            // Erreur
            default : 
                in.close();
                throw new ArithmeticException("Type de matrice invalide, veuillez relancer le programme.");
        }
        
        // Fermeture du Scanner afin d'eviter des fuites de memoire
        in.close();

        /******************
         *    Calculs     *
         ******************/
        MatriceLineaire resultat_ml = new MatriceLineaire(matrice);

        // Addition    
        // System.out.println("MatriceLineaire + MatriceLineaire = ");
        // ml.additionnerMatrice(ml, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();

        // System.out.println("MatriceCreuse + MatriceCreuse = ");
        // mc.additionnerMatrice(mc, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();

        // System.out.println("MatriceLineaire + MatriceCreuse = ");
        // ml.additionnerMatrice(mc, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();
        
        // // Multiplication
        // System.out.println("MatriceLineaire * MatriceLineaire = ");
        // ml.multiplierMatrice(ml, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();

        // System.out.println("MatriceCreuse * MatriceCreuse = ");
        // mc.multiplierMatrice(mc, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();

        // System.out.println("MatriceLineaire * MatriceCreuse = ");
        // ml.multiplierMatrice(mc, resultat_ml);
        // resultat_ml.afficherMatriceFormeLineaire();

        // Transposition
        resultat_ml = (MatriceLineaire)matrice;
        System.out.println("MatriceLineaire transposee = ");
        resultat_ml = (MatriceLineaire)ml.transposer(ml, resultat_ml);
        resultat_ml.afficherPartMatrice();

        System.out.println("MatriceCreuse transposee = ");
        mc.transposer(mc, resultat_ml);
        resultat_ml.afficherPartMatrice();
        
    }
}
