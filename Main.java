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
        // Declaration        
        Matrice matrice;        
        int taille;
        int type = 0;
        Scanner in = new Scanner(System.in);

        // Initialisation
        System.out.println("Bonjour ! Je suis un createur de matrices carrees, pour vous servir !");

        // Taille de la matrice
        System.out.println("Quelle est la taille de la matrice ? ");
        taille = in.nextInt();
        if(taille <= 0)
        {
            in.close();
            throw new ArithmeticException("Taille invalide, veuillez relancer le programme.");
        }
        
        // Type initial de la matrice
        System.out.println("Quel est son type initial ?");
        System.out.println("1 : matrice lineaire");
        System.out.println("2 : matrice creuse");
        System.out.println("3 : matrice dense");
        type = in.nextInt();

        // Initialisation de la matrice en fonction des informations donnees
        switch(type)
        {
            // Matrice lineaire
            case 1 : 
                matrice = new MatriceLineaire(taille);

                (new MatriceCreuse(matrice)).afficherMatrice();

                MatriceDense md1 = new MatriceDense(matrice);
                md1.afficherMatrice();
                md1.afficherMatriceDense();
                break;
            // Matrice creuse
            case 2 :
                matrice = new MatriceCreuse(taille);
                ((MatriceCreuse)matrice).afficherMatrice();

                (new MatriceLineaire(matrice)).afficherMatrice();;

                MatriceDense md2 = new MatriceDense(matrice);
                md2.afficherMatrice();
                md2.afficherMatriceDense();
                break;
            // Matrice dense
            case 3 :
                matrice = new MatriceDense(taille);
                ((MatriceDense)matrice).afficherMatrice();
                ((MatriceDense)matrice).afficherMatriceDense();
                
                (new MatriceLineaire(matrice)).afficherMatrice();;

                (new MatriceCreuse(matrice)).afficherMatrice();;
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