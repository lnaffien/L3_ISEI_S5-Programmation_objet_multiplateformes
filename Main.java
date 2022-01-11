import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        Matrice ml;
        System.out.println("Bonjour ! Je suis un createur de matrices carrees, pour vous servir !");

        int taille; 
        System.out.println("Quelle est la taille de la matrice ? ");
        taille = in.nextInt();
        if(taille <= 0)
        {
            throw new ArithmeticException("Taille invalide, veuillez relancer le programme.");
        }  
             
        // MatriceLineaire matLineaire = new MatriceLineaire(taille);
        // matLineaire.afficherMatrice();
        // MatriceCreuse matCreuse = new MatriceCreuse(matLineaire);
        // matLineaire.afficherMatrice();

        int type = 0;
        System.out.println("Quel est son type initial ?");
        System.out.println("1 : matrice lineaire");
        System.out.println("2 : matrice creuse");
        System.out.println("3 : matrice dense");
        type = in.nextInt();
        switch(type)
        {
            case 1 : 
                ml = new MatriceLineaire(taille);
                ml.afficherMatrice();
                break;
            case 2 :
                ml = new MatriceCreuse(taille);
                break;
            case 3 :
                ml = new MatriceDense(taille);
                break;
            default : 
                throw new ArithmeticException("Type de matrice invalide, veuillez relancer le programme.");
        }

        

        System.out.println("Veuillez indiquer les cases non nulles de la matrice sous la forme suivante : x(largeur) y(hauteur) valeur");
        System.out.println("Exemple :\n 0 0 5");
        System.out.println("Attention : une case deja enregistree sera reecrite.");
        System.out.println("Une fois termine, rentrez une valeur non valide (une lettre, un nombre reel...).");
        int x;
        int y;
        int value;
        /*while(1)
        {

        }*/
    }
}