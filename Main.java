import java.util.Scanner;

public class Main
{
    public static void main(String arg[])
    {
        Scanner in = new Scanner(System.in);
        Matrice matrice;
        System.out.println("Bonjour ! Je suis un createur de matrices carrees, pour vous servir !");

        int taille; 
        System.out.println("Quelle est la taille de la matrice ? ");
        taille = in.nextInt();
        if(taille <= 0)
        {
            in.close();
            throw new ArithmeticException("Taille invalide, veuillez relancer le programme.");
        }

        int type = 0;
        System.out.println("Quel est son type initial ?");
        System.out.println("1 : matrice lineaire");
        System.out.println("2 : matrice creuse");
        System.out.println("3 : matrice dense");
        type = in.nextInt();

        switch(type)
        {
            case 1 : 
                matrice = new MatriceLineaire(taille);
                matrice.afficherMatrice();
                //MatriceCreuse mc = new MatriceCreuse(matrice);
                // MatriceDense md = new MatriceDense(matrice);
                break;
            case 2 :
                matrice = new MatriceCreuse(taille);
                matrice.afficherMatrice();                
                // MatriceLineaire ml = new MatriceLineaire(matrice);
                // MatriceDense md = new MatriceDense(matrice);
                break;
            case 3 :
                matrice = new MatriceDense(taille);
                matrice.afficherMatrice();                
                // MatriceLineaire ml = new MatriceLineaire(matrice);
                // MatriceCreuse mc = new MatriceCreuse(matrice);
                break;
            default : 
                in.close();
                throw new ArithmeticException("Type de matrice invalide, veuillez relancer le programme.");
        }

        
        in.close();
       
    }
}