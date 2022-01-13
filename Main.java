/***********************************************************************************************************************************************

                                                                Main
                                                                            par NAFFIEN Lucie (janvier 2022)

Cette classe appartient a un projet realise pour le module "Programmation objet multiplateformes", enseigne par M. MARIAGE, dans le cadre 
de la 3eme annee de licence parcours Informatique des Systemes Embarques et Interactifs de l'Universite Paris 8.

Lien github de l'ensemble du projet : https://github.com/lnaffien/L3_ISEI_S5-Programmation_objet_multiplateformes


************************************************************************************************************************************************/

import java.util.Scanner;

public class Main
{
    
    public static void main(String arg[])
    {
        // Declaration des variables locales.
        Matrice matrice;
        MatriceLineaire ml;
        MatriceCreuse mc;
        MatriceDense md;     
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
        System.out.println("3 : matrice dense");
        type = in.nextInt();

        // Initialisation de la matrice en fonction des informations donnees.
        switch(type)
        {
            // Matrice lineaire
            case 1 : 
                ml = new MatriceLineaire(taille);
                matrice = ml;

                mc = new MatriceCreuse(matrice);
                mc.afficherMatrice();

                md = new MatriceDense(matrice);
                md.afficherMatrice();
                md.afficherMatriceDense();

                break;

            // Matrice creuse
            case 2 :
                mc = new MatriceCreuse(taille);
                mc.afficherMatrice();                
                matrice = mc;

                ml = new MatriceLineaire(matrice);
                ml.afficherMatrice();

                md = new MatriceDense(matrice);
                md.afficherMatrice();
                md.afficherMatriceDense();

                break;

            // Matrice dense
            case 3 :
                md = new MatriceDense(taille);
                md.afficherMatrice();
                md.afficherMatriceDense();
                matrice = md;
                
                ml = new MatriceLineaire(matrice);
                ml.afficherMatrice();

                mc = new MatriceCreuse(matrice);
                mc.afficherMatrice();

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
        System.out.println("MatriceLineaire + MatriceCreuse = ");
        Matrice m_addition_lc = ml.additionnerMatrice(mc);
        m_addition_lc.afficherMatrice();

        System.out.println("MatriceLineaire + MatriceDense = ");
        Matrice m_addition_ld = ml.additionnerMatrice(md);
        m_addition_ld.afficherMatrice();

        System.out.println("MatriceDense + MatriceCreuse = ");
        Matrice m_addition_dc = md.additionnerMatrice(mc);
        m_addition_dc.afficherMatrice();

        // Multiplication
        System.out.println("MatriceLineaire * MatriceCreuse = ");
        Matrice m_multiplication_lc = ml.multiplierMatrice(mc);
        m_multiplication_lc.afficherMatrice();

        System.out.println("MatriceLineaire * MatriceDense = ");
        Matrice m_multiplication_ld = ml.multiplierMatrice(md);
        m_multiplication_ld.afficherMatrice();

        System.out.println("MatriceDense * MatriceCreuse = ");
        Matrice m_multiplication_dc = md.multiplierMatrice(mc);
        m_multiplication_dc.afficherMatrice();
       
    }
}