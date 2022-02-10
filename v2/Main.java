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

        // Addition    
        System.out.println("MatriceLineaire + MatriceLineaire = ");
        Matrice m_addition_ld = ml.additionnerMatrice(ml);
        m_addition_ld.afficherMatriceFormeLineaire();

        System.out.println("MatriceCreuse + MatriceCreuse = ");
        Matrice m_addition_dc = mc.additionnerMatrice(mc);
        m_addition_dc.afficherMatriceFormeLineaire();

        System.out.println("MatriceLineaire + MatriceCreuse = ");
        Matrice m_addition_lc = ml.additionnerMatrice(mc);
        m_addition_lc.afficherMatriceFormeLineaire();
        
        // Multiplication
        System.out.println("MatriceLineaire * MatriceLineaire = ");
        Matrice m_multiplication_ld = ml.multiplierMatrice(ml);
        m_multiplication_ld.afficherMatriceFormeLineaire();

        System.out.println("MatriceCreuse * MatriceCreuse = ");
        Matrice m_multiplication_dc = mc.multiplierMatrice(mc);
        m_multiplication_dc.afficherMatriceFormeLineaire();

        System.out.println("MatriceLineaire * MatriceCreuse = ");
        Matrice m_multiplication_lc = ml.multiplierMatrice(mc);
        m_multiplication_lc.afficherMatriceFormeLineaire();
        
    }
}
